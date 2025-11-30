package com.example.cuentosfrontend.ui.screens1

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.R
import com.example.cuentosfrontend.ui.components.Web.GradientButton
import com.example.cuentosfrontend.ui.theme.PorkyS
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.cuentosfrontend.data.DTO.Language
import com.example.cuentosfrontend.screens.LanguageDropdown
import com.example.cuentosfrontend.data.viewmodel.MainViewModel
import com.example.cuentosfrontend.data.viewmodel.UserState



@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    val viewModel: MainViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    var name by remember { mutableStateOf(TextFieldValue("")) }

    val languages = listOf(
        Language(1, "Spanish"),
        Language(2, "English")
    )
    var selectedLanguage by remember { mutableStateOf(languages[0]) }

    val isLoading = state is UserState.Loading
    val context = LocalContext.current

    val accentColor = Color(0xFF6A1B9A)
    val buttonColorStart = Color(0xFF8E24AA)
    val buttonColorEnd = Color(0xFF6A1B9A)

    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight()
                    .background(Color(0xFFD0A2F7).copy(0.5f))
            )

            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(48.dp),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.dragonanim)
                        .decoderFactory(ImageDecoderDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(220.dp)
                        .align(Alignment.TopCenter)
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {

                    Text(
                        text = "Bienvenido",
                        color = accentColor,
                        fontSize = 48.sp,
                        fontFamily = PorkyS,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )

                    // Campo de nombre
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Tu nombre", color = accentColor) },
                        textStyle = LocalTextStyle.current.copy(color = accentColor),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = accentColor,
                            unfocusedIndicatorColor = accentColor.copy(alpha = 0.5f),
                            cursorColor = accentColor
                        )
                    )

                    // Selector de idioma
                    LanguageDropdown(
                        languages = languages,
                        selectedLanguage = selectedLanguage,
                        accentColor = accentColor
                    ) {
                        selectedLanguage = it
                    }

                    // Botón Entrar
                    GradientButton(
                        text = if (isLoading) "Cargando..." else "Entrar",
                        enabled = !isLoading,
                        gradientColors = listOf(buttonColorStart, buttonColorEnd),
                    ) {
                        if (name.text.isNotBlank()) {

                            // 🔥 Registrar usuario con el lenguaje seleccionado
                            viewModel.registerUser(selectedLanguage)

                        } else {
                            Toast.makeText(
                                context,
                                "Falta poner tu nombre",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    // Respuesta del ViewModel
                    LaunchedEffect(state) {
                        when (state) {
                            is UserState.Success -> {
                                Toast.makeText(
                                    context,
                                    (state as UserState.Success).message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            is UserState.Error -> {
                                Toast.makeText(
                                    context,
                                    (state as UserState.Error).error,
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                            else -> {}
                        }
                    }
                }
            }
        }
    }
}
