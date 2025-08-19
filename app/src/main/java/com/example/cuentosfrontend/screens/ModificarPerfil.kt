package com.example.cuentosfrontend.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.ui.components.Web.ButtonConfirmar
import com.example.cuentosfrontend.ui.components.Web.FlechaAtras
import com.example.cuentosfrontend.ui.components.Web.Music




@Composable
fun ModificarPerfil(
    navController: NavHostController,
    username: String,
    language: String,
    avatarIdInicial: Int,
    modifier: Modifier = Modifier
) {
    BodyModificar(
        navController = navController,
        username = username,
        language = language,
        avatarIdInicial = avatarIdInicial,
        modifier = modifier
    )
}

@Composable
fun AvatarModificar(
    navController: NavHostController,
    avatarId: Int,
    name: String,
    language: String
){
    Image(
        painter = painterResource(id = avatarId),
        contentDescription = "Perfil",
        modifier = Modifier
            .size(450.dp)
            .clip(CircleShape)
            .clickable {
                navController.navigate("choosemodif_avatar/$name/$language")
            }
    )
}


@Composable
fun NameUserLogin(
    name: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Nombre de usuario") },
        modifier = modifier,
        singleLine = true
    )
}

@Composable
fun BodyModificar(navController: NavHostController,
                  username: String,
                  language: String,
                  avatarIdInicial: Int, modifier: Modifier =Modifier) {
//AvatarActual y los campos nombre e idioma
    var avatarId by remember { mutableStateOf(avatarIdInicial) }
    var name by remember { mutableStateOf(username) }
    var selectedLanguage by remember { mutableStateOf(language) }

    val context = LocalContext.current

    // Escuchar cambios del avatar desde ChosseAvatarScreen
    LaunchedEffect(Unit) {
        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Int>("avatarId")
            ?.observeForever { nuevoAvatar ->
                avatarId = nuevoAvatar
            }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)

    ) {
        Music()


        // Flecha atrás en esquina superior izquierda
        FlechaAtras {
            navController.popBackStack() // Volver sin cambios
        }

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        )
        {
            // Avatar clickeable
            AvatarModificar(navController = navController, avatarId = avatarId, name = name, language = selectedLanguage)


            // Contenido a la derecha
            Column(modifier = Modifier.padding(5.dp)) {

                NameUserLogin(
                    name = name,
                    onNameChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                LanguageLogin(
                    selectedLanguage = selectedLanguage,
                    onLanguageSelected = { selectedLanguage = it }
                )
            }
        }

                Spacer(modifier = Modifier.height(30.dp))

        ButtonConfirmar(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 40.dp, bottom = 40.dp),
            onClick = {
                if (name.isNotBlank()) {
                    navController.navigate("HomeScreen/$name/$selectedLanguage/$avatarId") {
                        popUpTo("HomeScreen/$name/$selectedLanguage/$avatarId") { inclusive = true }
                    }
                } else {
                    Toast.makeText(context, "Introduce un nombre", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}