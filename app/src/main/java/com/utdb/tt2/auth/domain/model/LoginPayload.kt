package com.utdb.tt2.auth.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginPayload(
    @SerialName("mobile_number")
    val username: String,
    @SerialName("password")
    val password: String,
)