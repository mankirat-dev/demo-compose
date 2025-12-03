package com.utdb.tt2.shared.presentation.components.fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utdb.tt2.R
import com.utdb.tt2.ui.theme.ErrorRed

//final TextEditingController? controller;
//final Color? fillColor;
//final bool? enableInteractiveSelection;
//final bool? filled;
//final ValueChanged<String>? onFieldSubmitted;
//final ValueChanged<String>? onChanged;
//final TextCapitalization textCapitalization;
//final bool isRequired;

//BaseTextField({
//    super.key,
//    this.controller,
//    this.fillColor,
//    this.enableInteractiveSelection,
//    this.filled,
//    this.onFieldSubmitted,
//    this.onChanged,
//    this.textCapitalization = TextCapitalization.none,
//    bool? isRequired,
//})  :
//isRequired = isRequired ?? true,

@Composable
fun BaseTextField(
    title: String,
    hint: String = stringResource(R.string.enter_hint, title),
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardOptions.Default.keyboardType,
    imeAction: ImeAction = ImeAction.Next,
    minLines: Int = 1,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isPassword: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isRequired: Boolean = true,
    showTitle: Boolean = true,
    fillColor: Color = Color.Transparent,
    filled: Boolean = false,
    enabled: Boolean = true,
    onSubmit: ((String) -> Unit)? = null,
    onFocusChanged: ((Boolean) -> Unit)? = null
) {
    var isFocused by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    Column(modifier = Modifier) {
        if (showTitle) {
            Text(
                text = if (isRequired) "$title *" else title,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = hint) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = { onSubmit?.invoke(value) },
                onDone = { onSubmit?.invoke(value) }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isFocused = it.isFocused
                    onFocusChanged?.invoke(it.isFocused)
                },
            maxLines = maxLines,
            minLines = minLines,
            visualTransformation = visualTransformation,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            enabled = enabled,
            singleLine = maxLines == 1,
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = if (filled) fillColor else Color.Transparent
//            )
        )
        if(isError) {
            Text(
                text = "Error",
                style = TextStyle(
                    color = ErrorRed,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}
