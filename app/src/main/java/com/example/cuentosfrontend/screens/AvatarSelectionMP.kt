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
import com.example.cuentosfrontend.ui.components.Web.ButtonConfirmar
import com.example.cuentosfrontend.ui.components.Web.Music


@Composable
fun ChosseAvatarScreenModif(
    navController: NavHostController,
    username: String,
    language: String,
    modifier: Modifier = Modifier
) {
    BodyChooseAvatarModif(navController, username, language, modifier)
}

@Composable
fun BodyChooseAvatarModif(
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
        Music(modifier) // Asumo que es un componente de música de fondo
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            AvatarSelectedModif(
                onAvatarSelected = { avatarId ->
                    selectedAvatar = avatarId
                }
            )
        }
        ButtonConfirmar(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 40.dp, bottom = 40.dp),
            onClick = {
                // Guardar avatarId seleccionado en savedStateHandle de la pantalla anterior
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("avatarId", selectedAvatar)

                navController.popBackStack()
            }
        )


    }
}

@Composable
fun AvatarSelectedModif(onAvatarSelected: (Int) -> Unit) {
    val avatars = listOf(
        R.drawable.dragon_estatico,
        R.drawable.cocodrilo_estatico,
        R.drawable.pajaro_estatico,
        R.drawable.perrita_estatica,
        R.drawable.zorro_estatico,
        R.drawable.tigre_estatico
    )

    var selectedAvatar by remember { mutableStateOf(avatars.first()) }
    val availableAvatars = avatars.filter { it != selectedAvatar }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar seleccionado (grande)
        Image(
            painter = painterResource(id = selectedAvatar),
            contentDescription = "Avatar seleccionado",
            modifier = Modifier
                .size(450.dp)
                .clip(CircleShape)
                .clickable {
                    // Opcional: tal vez quieres que al hacer click en el avatar grande no pase nada
                }
        )

        Spacer(modifier = Modifier.width(32.dp))

        // Avatares secundarios en columna, 2 por fila
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (i in availableAvatars.indices step 2) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    AvatarOptionModif(
                        avatarResId = availableAvatars[i],
                        isSelected = false,
                        onClick = {
                            selectedAvatar = availableAvatars[i]
                            onAvatarSelected(availableAvatars[i])
                        }
                    )
                    if (i + 1 < availableAvatars.size) {
                        AvatarOptionModif(
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
fun AvatarOptionModif(avatarResId: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Avatar opción",
            modifier = Modifier.clip(CircleShape)
        )
    }
}
