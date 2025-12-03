package com.utdb.tt2.auth.domain.enums

enum class Gender(val id: Int) {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    companion object {
        fun fromId(id: Int?): Gender? = Gender.entries.firstOrNull { it.id == id }
    }
}