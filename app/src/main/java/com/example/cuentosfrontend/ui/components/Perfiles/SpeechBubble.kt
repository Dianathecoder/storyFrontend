package com.example.cuentosfrontend.ui.components.Perfiles

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
@Composable
fun SpeechBubbleComic(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFFFF176), // Amarillo brillante
    textColor: Color = Color.Black
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Globo ovalado
        Box(
            modifier = Modifier
                .background(backgroundColor, shape = RoundedCornerShape(100)) // muy redondo
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }

        // Cola tipo cómic (más grande y desplazada)
        Canvas(modifier = Modifier.size(40.dp)) {
            val path = Path().apply {
                moveTo(size.width / 2, 0f)
                quadraticBezierTo(
                    size.width * 0.2f, size.height * 0.5f,
                    0f, size.height
                )
                lineTo(size.width, size.height)
                quadraticBezierTo(
                    size.width * 0.8f, size.height * 0.5f,
                    size.width / 2, 0f
                )
                close()
            }
            drawPath(path, backgroundColor)
        }
    }
}
