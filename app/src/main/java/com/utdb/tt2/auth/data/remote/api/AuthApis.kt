package com.utdb.tt2.auth.data.remote.api

import com.utdb.tt2.auth.data.remote.dto.LoginFormResponseDto
import com.utdb.tt2.auth.data.remote.dto.LoginResponseDto
import com.utdb.tt2.auth.data.remote.mapper.toDomain
import com.utdb.tt2.auth.domain.model.LoginFormResponse
import com.utdb.tt2.auth.domain.model.LoginPayload
import com.utdb.tt2.auth.domain.model.LoginResponse
import com.utdb.tt2.shared.data.remote.api.ApiClient
import io.ktor.http.HttpMethod
import javax.inject.Inject

class AuthApis @Inject constructor(
    private val apiClient: ApiClient,
) {

    suspend fun getLoginForm() = apiClient.callApi<LoginFormResponseDto, LoginFormResponse>(
        endPoint = "login-form",
        httpMethod = HttpMethod.Companion.Get,
        mapper = LoginFormResponseDto::toDomain,
    )

    suspend fun login(loginPayload: LoginPayload) = apiClient.callApi<LoginResponseDto, LoginResponse>(
        endPoint = "login",
        httpMethod = HttpMethod.Companion.Post,
        mapper = LoginResponseDto::toDomain,
        payload = loginPayload,
//        payload = buildJsonObject {
//            put("mobile_number", JsonPrimitive(username))
//            put("password", JsonPrimitive(password))
//        }
    )

}

