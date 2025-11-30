package com.example.cuentosfrontend.ui.components.Web

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 🎨 Botón con fondo degradado reutilizable (ahora en tonos lilas)
 */
@Composable
fun GradientButton(
    text: String,
    enabled: Boolean = true,
    gradientColors: List<Color> = listOf(Color(0xFF8E24AA), Color(0xFF6A1B9A)), // Degradado lila
    onClick: () -> Unit
) {
    val gradient = Brush.horizontalGradient(gradientColors)

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(30.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier.background(gradient).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}
