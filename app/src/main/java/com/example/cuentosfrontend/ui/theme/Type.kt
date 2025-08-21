package com.example.cuentosfrontend.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cuentosfrontend.R



val Flowers = FontFamily(
    Font(R.font.indieflowertegular)

)

val Griffy_Regular= FontFamily(
    Font(R.font.griffy_regular)

)
val Mystery_Regular= FontFamily(
    Font(R.font.mysteryquest_regular)

)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)