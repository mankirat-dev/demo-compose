package com.utdb.tt2.shared.presentation.components.layout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun AuthPlaceholder(
    @DrawableRes imageRes: Int,
) {
    Image(
        painter = painterResource(id = imageRes),
        //colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(0.6f)
    )
}