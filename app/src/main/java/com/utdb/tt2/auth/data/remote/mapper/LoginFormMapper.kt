package com.utdb.tt2.auth.data.remote.mapper

import com.utdb.tt2.auth.data.remote.dto.LoginFormResponseDto
import com.utdb.tt2.auth.domain.model.LoginFormResponse

fun LoginFormResponseDto.toDomain() = LoginFormResponse(
    appBarTitle = formFields.firstOrNull()?.toDomain(),
    username = inputFields.firstOrNull()?.toDomain(),
    password = inputFields.getOrNull(1)?.toDomain(),
    forgotPassword = linkFields.firstOrNull()?.toDomain(),
    submitButton = buttonFields.firstOrNull()?.toDomain(),
)

