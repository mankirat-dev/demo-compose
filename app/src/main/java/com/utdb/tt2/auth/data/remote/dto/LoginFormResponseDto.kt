package com.utdb.tt2.auth.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginFormResponseDto(
    @SerialName("input_fields")
    val inputFields: List<AuthFormFieldDto>,
    @SerialName("button_fields")
    val buttonFields: List<AuthFormFieldDto>,
    @SerialName("link_fields")
    val linkFields: List<AuthFormFieldDto>,
    val formFields: List<AuthFormFieldDto>,
)