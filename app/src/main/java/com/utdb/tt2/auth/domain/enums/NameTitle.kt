package com.utdb.tt2.auth.domain.enums

enum class NameTitle(val id: Int) {
    MR(1),
    MRS(2),
    MISS(3),
    MS(4),
    DR(5);

    companion object {
        fun fromId(id: Int?): NameTitle? = NameTitle.entries.firstOrNull { it.id == id }
    }
}