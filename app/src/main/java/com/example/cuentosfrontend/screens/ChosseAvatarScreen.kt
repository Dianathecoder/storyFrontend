package com.example.cuentosfrontend.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.R
import com.example.cuentosfrontend.ui.components.ButtonContinuar
import com.example.cuentosfrontend.ui.components.Music



@Composable
fun ChosseAvatarScreen(navController: NavHostController,username:String,modifier: Modifier =Modifier) {
    BodyChooseAvatar(navController, username,modifier)

}



@Composable
fun AvatarOption(avatarResId: Int, isSelected: Boolean, onClick: () -> Unit){
    Box(
        modifier = Modifier
            .size(250.dp)
            .clip(CircleShape) ,// Fondo uniforme opcional
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Avatar opción",
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onClick)
        )
    }
}
//Muestra una fila de imágenes circulares
@Composable
fun AvatarSelected(onAvatarSelected: (Int) -> Unit) {
    val avatars = listOf(
        R.drawable.perfil_dragon,
        R.drawable.perfil_cocodrilo,
        R.drawable.perfil_pajaro,
        R.drawable.perfil_perro,
        R.drawable.zorro_perfil
    )

    var selectedAvatar by remember { mutableStateOf(avatars.first()) }
    val availableAvatars = avatars.filter { it != selectedAvatar }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Center, // Centra horizontalmente el Row
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar seleccionado (grande)
        Image(
            painter = painterResource(id = selectedAvatar),
            contentDescription = "Avatar seleccionado",
            modifier = Modifier
                .size(500.dp)
                .clip(CircleShape)

        )

        Spacer(modifier = Modifier.width(32.dp)) // Separación entre avatar grande y la columna

        // Columna con avatares (dos por fila) con peso para balancear el espacio
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            for (i in availableAvatars.indices step 2) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)

                ) {
                    AvatarOption(
                        avatarResId = availableAvatars[i],
                        isSelected = false,
                        onClick = {
                            selectedAvatar = availableAvatars[i]
                            onAvatarSelected(availableAvatars[i])
                        }
                    )
                    if (i + 1 < availableAvatars.size) {
                        AvatarOption(
                            avatarResId = availableAvatars[i + 1],
                            isSelected = false,
                            onClick = {
                                selectedAvatar = availableAvatars[i + 1]
                                onAvatarSelected(availableAvatars[i + 1])
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BodyChooseAvatar(navController: NavHostController, username: String,modifier: Modifier = Modifier) {
    var selectedAvatar by remember { mutableStateOf(R.drawable.perfil_dragon) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Music(modifier)
        // Centra el selector de avatar
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
                navController.navigate("HomeScreen/$username/$selectedAvatar")
            }
        )
    }
}



