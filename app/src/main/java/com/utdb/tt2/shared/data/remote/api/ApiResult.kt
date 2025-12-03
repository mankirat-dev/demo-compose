package com.utdb.tt2.shared.data.remote.api

import kotlinx.serialization.Serializable

sealed class ApiResult<T> {
    @Serializable
    data class Success<T>(val message: String, val data: T) : ApiResult<T>()
    class NoData<T>(val message: String) : ApiResult<T>()
    class UnknownError<T>(val message: String) : ApiResult<T>()
    class JsonParsingError<T>(val message: String = "Parsing error") : ApiResult<T>()
    class SlowInternetError<T>(val message: String = "Slow Internet") : ApiResult<T>()
    class NoInternetError<T>(val message: String = "No Internet") : ApiResult<T>()
    class LoginSessionExpired<T> : ApiResult<T>()
}