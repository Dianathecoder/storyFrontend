package com.example.cuentosfrontend.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.cuentosfrontend.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.ui.components.Web.Music


@Composable
fun HomeScreen(
    avatarId: Int,
    username: String,
    language: String,
    navController: NavHostController


){
    BodyHome(navController, username, language, avatarId)

}
@Composable
fun CuentoPortadaButton(
    navController: NavController,
    cuentoId: String,
    titulo: String,
    descripcion: String,
    drawableResId: Int,
    bubbleColor: Color = Color(0xFFFFA726)
) {
    var bubbleVisible by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {


    }
}






@Composable
fun BodyHome(
        navController: NavHostController,
        username: String,
        language: String,
        avatarId: Int,
        modifier: Modifier = Modifier,
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Music()



            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {


                // Cuento portada con peso
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CuentoPortadaButton(
                        navController = navController,
                        cuentoId = "1-tigreproruc",
                        titulo = "El tigre poruc",
                        descripcion = "Oscar no esta seguro de ser un buen lider pero sus amigos no piensan lo mismo",
                        drawableResId = R.drawable.tigre,
                        bubbleColor = Color(0xFFFF7043)
                    )
                }
            }
        }
    }

