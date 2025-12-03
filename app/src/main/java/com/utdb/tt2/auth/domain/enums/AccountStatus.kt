package com.utdb.tt2.auth.domain.enums

enum class AccountStatus(val id: Int) {
    IN_ACTIVE(0),
    ACTIVE(1),
    BLOCKED(2),
    PENDING(3);

    companion object {
        fun fromId(id: Int?): AccountStatus? = AccountStatus.entries.firstOrNull { it.id == id }
    }
}