package com.utdb.tt2.auth.data.remote.dto

import com.utdb.tt2.shared.util.DateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class LoginResponseDto(
    val user: UserDto,
    val token: String,
    @Serializable(with = DateTimeSerializer::class)
    @SerialName("expire_at")
    val expireAt: Date,
)