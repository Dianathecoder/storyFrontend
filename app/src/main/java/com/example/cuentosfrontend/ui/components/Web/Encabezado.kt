/*package com.example.cuentosfrontend.ui.components.Web

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuentosfrontend.R
import com.example.cuentosfrontend.ui.components.Avates.AvatarConstants
import com.example.cuentosfrontend.ui.components.Avates.GifImage
import com.example.cuentosfrontend.utils.UiConstants


@Composable
fun Perfil(
    avatarId: Int,
    username: String,
    onClick: () -> Unit = {}
) {
    val fondoId = AvatarConstants.avatarToFondoMap[avatarId] ?: AvatarConstants.defaultFondo
    val avatarSize = 100.dp

    //Para saber si el cursor esta encima
    var isHovered by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        // Foto de perfil grande a la izquierda
        ProfileSmall(
            avatarId = avatarId,
            modifier = Modifier.size(avatarSize)
        )



        // Fondo con el nombre a la derecha, tamaño adaptado al texto
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .height(60.dp)
                .wrapContentWidth()
        ) {
            Image(
                painter = painterResource(id = fondoId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Text(
                text = username,
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}


@Composable
fun FlechaAtras( modifier: Modifier = Modifier,
                 onClick: () -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
    Image(
        painter = painterResource(id = UiConstants.ICON_BACK),
        contentDescription = "Volver",
        modifier = Modifier
            .size(50.dp)
            .align(Alignment.TopStart)
            .clickable { onClick() }
    )
}
}




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


@Composable
fun TitleScreen(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()//Que ocupe todo el espacio posibe
            .padding(),//posicion,ya se vera
        fontSize = 48.sp,//Tamaño
        color = Color(0xFF6A4C93),//Color
        textAlign = TextAlign.Start//Que empieze a la izquierda(puede cambiar)
    )
}


@Composable
fun ProfileSmall(avatarId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = avatarId),
        contentDescription = "Avatar perfil pequeño",
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}
*/
