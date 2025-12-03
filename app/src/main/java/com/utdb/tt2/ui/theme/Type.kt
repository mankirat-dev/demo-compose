package com.utdb.tt2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.utdb.tt2.R

val PoppinsFontFamily = FontFamily(
    Font(R.font.poppins_200_extra_light, FontWeight.ExtraLight),
    Font(R.font.poppins_300_light, FontWeight.Light),
    Font(R.font.poppins_400_regular, FontWeight.Normal),
    Font(R.font.poppins_500_medium, FontWeight.Medium),
    Font(R.font.poppins_600_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_700_bold, FontWeight.Bold),
    Font(R.font.poppins_800_extra_bold, FontWeight.ExtraBold),
    Font(R.font.poppins_900_black, FontWeight.Black)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)