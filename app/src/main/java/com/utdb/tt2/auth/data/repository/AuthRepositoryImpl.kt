package com.utdb.tt2.auth.data.repository

import com.utdb.tt2.auth.data.remote.api.AuthApis
import com.utdb.tt2.auth.domain.model.LoginFormResponse
import com.utdb.tt2.auth.domain.model.LoginPayload
import com.utdb.tt2.auth.domain.model.LoginResponse
import com.utdb.tt2.auth.domain.repository.AuthRepository
import com.utdb.tt2.shared.data.remote.api.ApiResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApis,
) : AuthRepository {

    override suspend fun getLoginForm(): ApiResult<LoginFormResponse> {
        return api.getLoginForm()
    }

    override suspend fun login(username: String, password: String): ApiResult<LoginResponse> {
        return api.login(LoginPayload(username, password))
    }

}