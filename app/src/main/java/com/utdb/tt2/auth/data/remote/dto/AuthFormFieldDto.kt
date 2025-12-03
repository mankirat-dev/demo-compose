package com.utdb.tt2.auth.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthFormFieldDto(
    val id: Int,
    @SerialName("name_en")
    val nameEn: String,
    @SerialName("name_hi")
    val nameHi: String,
    @SerialName("input_field_name")
    val inputFieldName: String,
    @SerialName("placeholder_en")
    val placeholderEn: String? = null,
    @SerialName("placeholder_hi")
    val placeholderHi: String? = null,
    val type: String,
    val url: String? = null,
    @SerialName("field_max_length")
    val fieldMaxLength: String? = null,
    val required: String,
    val status: String,
    val sort: Int? = null,
    val icon: String? = null,
    @SerialName("font_family_id")
    val fontFamilyId: Int,
    @SerialName("font_color")
    val fontColor: String,
    @SerialName("font_size")
    val fontSize: String,
    @SerialName("background_color")
    val backgroundColor: String? = null,
    @SerialName("dropdown_values")
    val dropdownValues: String? = null,
    val validations: String? = null,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("deleted_at")
    val deletedAt: String? = null
)