package com.utdb.tt2.auth.domain.repository

import com.utdb.tt2.auth.domain.model.LoginFormResponse
import com.utdb.tt2.auth.domain.model.LoginResponse
import com.utdb.tt2.shared.data.remote.api.ApiResult

interface AuthRepository {

    suspend fun getLoginForm(): ApiResult<LoginFormResponse>

    suspend fun login(username: String, password: String): ApiResult<LoginResponse>

}