package com.example.cuentosfrontend.ui.components.Web

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cuentosfrontend.R

@Composable
fun Music(modifier: Modifier = Modifier){
    var musicaActivada by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(
                if (musicaActivada) R.drawable.icono_musica else R.drawable.icono_musica_negativo
            ),
            contentDescription = if (musicaActivada) "Música activada" else "Música desactivada",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .clickable {
                    musicaActivada = !musicaActivada
                    // Aquí puedes agregar lógica para activar/desactivar sonido
                }
                .align(Alignment.TopEnd)
        )
    }
}