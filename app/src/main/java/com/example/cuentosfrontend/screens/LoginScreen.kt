package com.example.cuentosfrontend.screens

import androidx.compose.ui.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.cuentosfrontend.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.ui.components.Web.BotonEntrar
import com.example.cuentosfrontend.ui.theme.Mystery_Regular
import com.example.cuentosfrontend.ui.components.Perfiles.GifImage




@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    BodyLogin(navController, modifier)
}


@Composable
fun GifLogin(modifier: Modifier) {
    GifImage(
        gifRes = R.drawable.dragonanim,
        size = 300.dp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameUserLogin(
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "Nombre",
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = Mystery_Regular,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                onNameChange(it)
            },
            textStyle = MaterialTheme.typography.titleMedium.copy(
                fontFamily = Mystery_Regular,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors()
        )
    }
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

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "Idioma",
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = Mystery_Regular,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            TextField(
                readOnly = true,
                value = selectedLanguage,
                onValueChange = {},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                },
                modifier = Modifier.menuAnchor().fillMaxWidth(0.4f),
                singleLine = true,
                shape = RoundedCornerShape(24.dp),
                textStyle = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = Mystery_Regular,
                    fontSize = 20.sp
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,   // sin línea cuando está enfocado
                    unfocusedIndicatorColor = Color.Transparent, // sin línea cuando no está enfocado
                    disabledIndicatorColor = Color.Transparent
                )
            )


            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                languages.forEach { lang ->
                    DropdownMenuItem(
                        text = { Text(lang, fontSize = 20.sp) },
                        onClick = {
                            onLanguageSelected(lang)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun BodyLogin(navController: NavHostController, modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var selectedLanguage by remember { mutableStateOf("Español") }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
            .background(Color(0xFFE1F5FE)) // Azul claro más suave

    ) {
        // Dragón como fondo
        Box(
            modifier = Modifier.matchParentSize()
        ) {
            GifLogin(Modifier.align(Alignment.Center))
        }

        // Contenedor central más estrecho
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .width(500.dp) //
                .background(
                    color = Color.White.copy(alpha = 0.1f), // transparente
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color.White.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = Mystery_Regular,
                        fontSize = 28.sp,
                        color = Color.Black
                    )
                )
                NameUserLogin(
                    onNameChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                LanguageLogin(
                    selectedLanguage = selectedLanguage,
                    onLanguageSelected = { selectedLanguage = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                BotonEntrar(
                    onClick = {
                        if (name.isNotBlank()) {
                            navController.navigate("choose_avatar/$name/$selectedLanguage")
                        } else {
                            Toast.makeText(
                                context,
                                "Falta poner tu nombre",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )
            }
        }
    }
}










