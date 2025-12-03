package com.utdb.tt2.shared.presentation.components.fields

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.utdb.tt2.shared.presentation.components.misc.Validations

@Composable
fun MobileNumberTextField(
    title: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isRequired: Boolean = true,
) {

    BaseTextField(
        title = title,
        hint = hint,
        value = value,
        onValueChange = {
            if (it.matches(Regex(Validations.PHONE_NUMBER_INPUT_REGEX))) {
                onValueChange(it)
            }
        },
        isRequired = isRequired,
        keyboardType = KeyboardType.Phone,
    )
}