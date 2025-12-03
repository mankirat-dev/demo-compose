package com.utdb.tt2.auth.domain.model

data class AuthFormField(
    val id: Int? = null,
    val title: String,
    val hint: String? = null,
    val inputFieldName: String? = null,
    val isRequired: Boolean? = null,
    val isActive: Boolean? = null,
//    val deletedAt: String? = null,
//    val createdAt: String? = null,
//    val updatedAt: String? = null
)