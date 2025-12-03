package com.utdb.tt2.auth.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int? = null,
    //val title: NameTitle? = null,
    val name: String? = null,
    @SerialName("unique_id")
    val uniqueId: String? = null,
    @SerialName("mobile_number")
    val mobileNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("username")
    val userName: String? = null,
    //val gender: Gender? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null
)
