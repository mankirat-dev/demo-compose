package com.utdb.tt2.auth.data.remote.mapper

import com.utdb.tt2.auth.data.remote.dto.AuthFormFieldDto
import com.utdb.tt2.auth.data.remote.dto.UserDto
import com.utdb.tt2.auth.domain.model.AuthFormField
import com.utdb.tt2.auth.domain.model.UserModel
import com.utdb.tt2.shared.util.Constants

fun UserDto.toDomain() = UserModel(
    id = id,
)
