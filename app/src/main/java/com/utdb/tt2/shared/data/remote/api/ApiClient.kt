package com.utdb.tt2.shared.data.remote.api

import com.utdb.tt2.BuildConfig
import com.utdb.tt2.shared.util.Logger
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class ApiClient @Inject constructor() {
    companion object {
        private const val IS_HINDI = false
    }

    private val jsonConfig = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(jsonConfig)
        }
        install(Logging) {
            logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    Logger.log("ApiClient $message")
                }
            }
            level = LogLevel.BODY
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
        }
    }

    internal suspend inline fun <reified Dto, reified Domain> callApi(
        endPoint: String,
        httpMethod: HttpMethod,
        queryParameters: Map<String, String>? = null,
        payload: Any? = null,
        noinline mapper: ((Dto) -> Domain)? = null,
    ): ApiResult<Domain> {
        return try {
            val response = client.request("${BuildConfig.BASE_URL}/api/${endPoint}") {
                method = httpMethod
                contentType(ContentType.Application.Json)
                queryParameters?.forEach { (k, v) -> url.parameters.append(k, v) }
                when (payload) {
                    is JsonObject -> setBody(TextContent(Json.encodeToString(payload), ContentType.Application.Json))
                    is String -> setBody(TextContent(payload, ContentType.Application.Json))
                    null -> {}
                    else -> setBody(payload)
                }
            }

            if (mapper == null) {
                response.bodyFixed<ApiResult.Success<Domain>>()
            } else {
                val dtoResult = response.bodyFixed<ApiResult.Success<Dto>>()
                ApiResult.Success<Domain>(dtoResult.message, mapper(dtoResult.data))
            }
        } catch (e: UnknownHostException) {
            Logger.log("NoInternetError", e)
            ApiResult.NoInternetError()
        } catch (e: ConnectException) {
            Logger.log("SlowInternetError", e)
            ApiResult.SlowInternetError()
        } catch (e: MissingFieldException) {
            Logger.log("JsonParsingError", e)
            ApiResult.JsonParsingError()
        } catch (e: Exception) {
            Logger.log("UnknownError ${e::class.simpleName}", e)
            ApiResult.UnknownError("Unknown error")
        }
    }

    private suspend inline fun <reified T> HttpResponse.bodyFixed(): T {
        val rawJson = this.bodyAsText()
        val json = Json.parseToJsonElement(rawJson).jsonObject.toMutableMap()
        if (json.contains("messages")) {
            val messages = json["messages"]
            if (messages is Map<*, *>) {
                val message = if (IS_HINDI) messages["hindi"] else messages["english"]
                if (message is JsonElement) {
                    json["message"] = message
                }
            }
        }
        val fixedElement = JsonObject(json)
        return jsonConfig.decodeFromJsonElement<T>(fixedElement)
    }
}