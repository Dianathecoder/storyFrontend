/*package com.example.cuentosfrontend.ui.components.History

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuentosfrontend.ui.theme.Griffy_Regular



//Cuento
@Composable
fun ImagenAnimada(
    drawableResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    baseSize: Dp = 350.dp,
    expandedSize: Dp = 380.dp
) {
    // Animación de tamaño
    val imageSizeDp by animateDpAsState(
        targetValue = if (isSelected) expandedSize else baseSize,
        animationSpec = tween(durationMillis = 500),
        label = "imageSizeAnim"
    )

    // Contenedor con tamaño máximo fijo y contenido centrado
    Box(
        modifier = Modifier
            .size(expandedSize) // tamaño máximo siempre, evita saltos
            .clipToBounds(),    // recorta si algo se sale
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = drawableResId),
            contentDescription = null,
            modifier = Modifier
                .size(imageSizeDp) // este sí cambia
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = Color.Black.copy(alpha = 0.20f),
                    spotColor = Color.Black.copy(alpha = 0.20f),
                    clip = false
                )
                .clip(RoundedCornerShape(20.dp))
                .clickable { onClick()
                }

        )
    }
}
@Composable
fun PortadaConDescripcion(
    titulo: String,
    descripcion: String,
    bubbleVisible: Boolean,
    bubbleColor: Color = Color(0xFFFFA726),
    contentBelowBubble: (@Composable () -> Unit)? = null
) {
    val bubbleBgColor by animateColorAsState(
        targetValue = if (bubbleVisible) bubbleColor.copy(alpha = 0.3f) else Color.Transparent,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        // Título prácticamente pegado a la imagen
        Spacer(modifier = Modifier.height(1.dp))

        Text(
            text = titulo,
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = Griffy_Regular,
                fontSize = 28.sp // un poco más grande para destacar
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp)) // más pegado al bubble

        if (bubbleVisible) {
            SpeechBubbleHistory(
                text = descripcion,
                backgroundColor = bubbleBgColor,
                textColor = Color.Black,
                modifier = Modifier.fillMaxWidth(0.4f),
                fontSize = 26.sp // tamaño grande del texto del bubble
            )
            // Aquí renderizamos contenido adicional debajo del bocadillo
            contentBelowBubble?.invoke()
        }
    }
}
*/


