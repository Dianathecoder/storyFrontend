package com.example.cuentosfrontend.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cuentosfrontend.MainActivity
import com.example.cuentosfrontend.assets.model.Character3d
import com.example.cuentosfrontend.ui.components.Music
import com.example.cuentosfrontend.ui.components.ProfileSmall


@Composable
fun HomeScreen(
    avatarId: Int,
    username: String,
    navController: NavHostController,

){
    BodyHome(navController, username, avatarId = avatarId,)

}

@Composable
fun BodyHome(navController: NavHostController,
             username: String,
             avatarId: Int,
             modifier: Modifier = Modifier,



             ){
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Music()

        Row(
            modifier = Modifier.align(Alignment.TopStart),
            verticalAlignment = Alignment.CenterVertically
        ) {


            ProfileSmall(
                avatarId = avatarId,
                modifier = Modifier
            )

            Text(
                text = username,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .padding(horizontal = 12.dp, vertical = 6.dp)

            )

        }

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            Character3d()

            
        }


    }
}

