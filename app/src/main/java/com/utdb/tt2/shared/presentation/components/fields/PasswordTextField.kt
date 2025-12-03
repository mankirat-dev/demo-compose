package com.utdb.tt2.shared.presentation.components.fields

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun LoginAndOldPassword(
    title: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isRequired: Boolean = true,
) {

    PasswordTextField(
        title = title,
        hint = hint,
        value = value,
        onValueChange = onValueChange,
        isRequired = isRequired,
    )
}

@Composable
private fun PasswordTextField(
    title: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isRequired: Boolean = true,
) {

    var passwordVisible by remember { mutableStateOf(false) }

    BaseTextField(
        title = title,
        hint = hint,
        value = value,
        onValueChange = onValueChange,
        isRequired = isRequired,
        keyboardType = KeyboardType.Phone,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                },
            ) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                )
            }
        },
    )
}