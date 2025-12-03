package com.utdb.tt2.auth.domain.model

data class LoginResponse(
    val accessToken: AccessToken,
    val user: UserModel,
)