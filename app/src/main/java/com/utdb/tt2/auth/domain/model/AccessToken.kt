package com.utdb.tt2.auth.domain.model

import java.util.Date

data class AccessToken(
    val id: Int? = null,
    val token: String,
    val expireAt: Date,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)