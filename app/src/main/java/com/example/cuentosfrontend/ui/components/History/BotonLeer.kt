package com.example.cuentosfrontend.ui.components.History

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.cuentosfrontend.ui.theme.Mystery_Regular




@Composable
fun Botonleer(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    baseWidth: Dp = 140.dp,
    expandedWidth: Dp = 170.dp,
    baseHeight: Dp = 44.dp,
    expandedHeight: Dp = 52.dp,
    isSelected: Boolean = false,
    backgroundColor: Color = Color(0xFF2196F3),  // azul normal
    contentColor: Color = Color.Black
) {
    val width by animateDpAsState(targetValue = if (isSelected) expandedWidth else baseWidth)
    val height by animateDpAsState(targetValue = if (isSelected) expandedHeight else baseHeight)

    Button(
        onClick = onClick,
        modifier = modifier
            .width(width)
            .height(height),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp,
            focusedElevation = 3.dp,
            hoveredElevation = 3.dp
        )
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = Mystery_Regular,
                fontSize = 28.sp // un poco más grande para destacar
            ))

    }
}



