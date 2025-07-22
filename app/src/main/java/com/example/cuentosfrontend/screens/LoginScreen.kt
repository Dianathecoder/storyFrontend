package com.example.cuentosfrontend.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import com.example.cuentosfrontend.R
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

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.example.cuentosfrontend.ui.components.BotonEntrar
import com.example.cuentosfrontend.ui.components.Music


@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    BodyLogin(navController, modifier)
}


@Composable
fun AvatarLogin(modifier: Modifier) {

        Image(painter =  painterResource(R.drawable.perfil_dragon),
            contentDescription="PerfilUser",
            modifier = modifier
            .size(600.dp)
            .clip(CircleShape)
        )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameUserLogin(onNameChange: (String) -> Unit,
                  modifier: Modifier = Modifier) {// muestra el campo, recibe texto nombre, informa los cambios con OnNombreChange, modifier permite personalizar el diseño
    var name by remember { mutableStateOf("") }

            OutlinedTextField(
                value = name,
                onValueChange = {
                   name = it
                    onNameChange(it)
                },
                label = {
                    Text("Nombre")
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                singleLine = true

            )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageLogin(
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val languages = listOf("Español", "Catalán")

    ExposedDropdownMenuBox(//Contenedor, que registra cuando elmenu debe abrirse o cerrarase
        expanded = expanded,//controla si elmenu es visible
        onExpandedChange = { expanded = !expanded },//cuando el usuario toca textField alterna el valor de expanded
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
    ) {
        TextField(//Lo que el usuario ve y toca
            readOnly = true,//campo solo lectura
            value = selectedLanguage,
            onValueChange = {},
            label = { Text("Idioma") },
            trailingIcon = {////flecha que apunta abajo o arriba depende del menu
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            },
            modifier = Modifier.menuAnchor().fillMaxWidth(0.4f),
            singleLine = true
        )

        ExposedDropdownMenu(//Contener conlas opciones, visible si expanded es true
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { lang ->
                DropdownMenuItem(//opcion individual
                    text = { Text(lang) },
                    onClick = {
                        onLanguageSelected(lang)////Al pulsarlo invoca el onlanguageSelected para avisar al padre que idioma se aviso
                        expanded = false//esto es para cerrar el menu
                    }
                )
            }
        }
    }
}



@Composable
fun BodyLogin(navController: NavHostController, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var selectedLanguage by remember { mutableStateOf("Español") }
    val context = LocalContext.current//se usa para mostrar el Toast| puedes acceder a recursos, iniciar actividades, obtener servicios del sistema, inflar vistas tradicionales, entre otros.


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Music()

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start//coloca el Avatar y la Column uno junto al otro, sin centrarlos por separado.
        ) {
            // Avatar a la izquierda
            AvatarLogin(modifier)

            // Columna con el contenido a la derecha del Avatar
            Column(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                NameUserLogin(
                    onNameChange = { name = it },
                    modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(30.dp))

                LanguageLogin(
                    selectedLanguage = selectedLanguage,
                    onLanguageSelected = { selectedLanguage = it }
                )

                Spacer(modifier = Modifier.height(30.dp))


                BotonEntrar(
                    onClick = {//Toast: pequeña notificacion
                        if (name.isNotBlank()) {

                                // Esto se ejecuta cuando se completa el guardado
                                navController.navigate("choose_avatar")

                        } else {
                                Toast.makeText(context, "Falta poner tu nombre", Toast.LENGTH_SHORT).show()
                            }

                        }
                    )

                }
            }
        }
    }










