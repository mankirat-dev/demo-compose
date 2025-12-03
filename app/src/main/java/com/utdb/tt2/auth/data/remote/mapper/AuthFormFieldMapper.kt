package com.utdb.tt2.auth.data.remote.mapper

import com.utdb.tt2.auth.data.remote.dto.AuthFormFieldDto
import com.utdb.tt2.auth.domain.model.AuthFormField
import com.utdb.tt2.shared.util.Constants

fun AuthFormFieldDto.toDomain() = AuthFormField(
    id = id,
    title = if (Constants.isHindi) nameHi else nameEn,
    hint = if (Constants.isHindi) placeholderHi else placeholderEn,
    isRequired = required == "1",
    isActive = status == "1",
)

