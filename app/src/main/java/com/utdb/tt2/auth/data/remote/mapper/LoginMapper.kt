package com.utdb.tt2.auth.data.remote.mapper

import com.utdb.tt2.auth.data.remote.dto.LoginResponseDto
import com.utdb.tt2.auth.domain.model.AccessToken
import com.utdb.tt2.auth.domain.model.LoginResponse

fun LoginResponseDto.toDomain() = LoginResponse(
    user = user.toDomain(),
    accessToken = AccessToken(
        token = token,
        expireAt = expireAt,
    ),
)
