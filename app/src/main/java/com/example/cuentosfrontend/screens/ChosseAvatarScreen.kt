package com.example.cuentosfrontend.screens

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.R
import com.example.cuentosfrontend.ui.components.Perfiles.AnimatedAvatar
import com.example.cuentosfrontend.ui.components.Web.ButtonContinuar
import com.example.cuentosfrontend.ui.components.Web.Music
import com.example.cuentosfrontend.ui.components.Perfiles.SpeechBubbleComic
import com.example.cuentosfrontend.utils.AvatarConstants




@Composable
fun ChosseAvatarScreen(  // Solo una definición, la que recibe language
    navController: NavHostController,
    username: String,
    language: String,
    modifier: Modifier = Modifier
) {
    BodyChooseAvatar(navController, username, language, modifier)
}


@Composable
fun AvatarSelected(onAvatarSelected: (Int) -> Unit) {
    val avatars = AvatarConstants.avatarList//Lista avatares
    var selectedAvatar by remember { mutableStateOf(avatars.first()) }//guarda cual avatar ha sido seleccionado
    val animatedAvatar = AvatarConstants.animatedAvatars[selectedAvatar]
    val description = if (animatedAvatar != null) {
        AvatarConstants.avatarDescriptions[animatedAvatar.loopAnimation] ?: ""
    } else ""

    val bubbleColor = if (animatedAvatar != null) {
        AvatarConstants.avatarBubbleColors[animatedAvatar.loopAnimation] ?: Color(0xFFEFEFEF)
    } else Color(0xFFEFEFEF)


//Contenedor principal
    Column(//Orgqniza los avatares en filas verticales
        modifier = Modifier
            .fillMaxWidth()//Ocupa el ancho disponible
            .padding(horizontal = 20.dp, vertical = 20.dp),//Ecpacio alrededor del contenido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)//ESpacio entre filas de avatares
    ) {

        avatars.chunked(3).forEach { rowAvatars ->//Divide los avates en grupos de 3

            // Dibuja los 3 avatares horizontalmente.
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                rowAvatars.forEach { avatarResId ->
                    // Contenedor que mantiene posición para avatar y burbuja
                    Box(
                        modifier = Modifier
                            .width(280.dp)
                            .height(220.dp), // altura fija solo para el avatar, sin burbuja
                        contentAlignment = Alignment.TopCenter
                    ) {
                        // Escala + offset para levantar avatar cuando está seleccionado
                        val scale by animateFloatAsState(
                            targetValue = if (avatarResId == selectedAvatar) 1.2f else 1.0f,
                            label = "avatarScale"
                        )
                        val offsetY by animateDpAsState(
                            targetValue = if (avatarResId == selectedAvatar) (-16).dp else 0.dp,
                            label = "avatarOffsetY"
                        )

                       //Avatar con fondo sutil y efecto click
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(
                                    color = AvatarConstants.avatarBubbleColors[avatarResId]?.copy(alpha = 0.3f)
                                        ?: Color.LightGray.copy(alpha = 0.3f), // fondo sutil
                                    shape = CircleShape
                                )
                                .offset(y = offsetY)
                                .clickable {
                                    selectedAvatar = avatarResId
                                    onAvatarSelected(avatarResId)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            AnimatedAvatar(
                                avatarRes = avatarResId,
                                isSelected = avatarResId == selectedAvatar,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .scale(scale)
                            )
                        }

                        // Burbuja encima del avatar (dibujada después)
                        if (avatarResId == selectedAvatar) {
                            SpeechBubbleComic(
                                text = description,
                                backgroundColor = bubbleColor,
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .align(Alignment.TopCenter)
                                    .offset(y = (-150).dp)
                            )
                        }
                    }
                }
            }
        }
    }
}





@Composable
fun BodyChooseAvatar(
    navController: NavHostController,
    username: String,
    language: String,
    modifier: Modifier = Modifier
) {
    var selectedAvatar by remember { mutableStateOf(R.drawable.dragon_estatico) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Music(modifier)
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AvatarSelected(
                onAvatarSelected = { avatarId ->
                    selectedAvatar = avatarId
                }
            )
        }
        ButtonContinuar(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 40.dp, bottom = 40.dp),
            onClick = {
                Log.d("NAVIGATION", "Navigating to HomeScreen")
                navController.navigate("HomeScreen/$username/$language/$selectedAvatar")
            }
        )
    }
}
