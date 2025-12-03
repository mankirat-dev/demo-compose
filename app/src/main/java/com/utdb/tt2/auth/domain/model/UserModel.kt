package com.utdb.tt2.auth.domain.model

data class UserModel(
    val id: Int? = null,
    //val title: NameTitle? = null,
    val name: String? = null,
    val uniqueId: String? = null,
    val mobileNumber: String? = null,
    val email: String? = null,
    val userName: String? = null,
    //val gender: Gender? = null,
    val photo: String? = null,
    val password: String? = null,
    val address: String? = null,
    val districtId: Int? = null,
    val cityId: Int? = null,
    val pinCode: String? = null,
    //val accountStatus: AccountStatus? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)