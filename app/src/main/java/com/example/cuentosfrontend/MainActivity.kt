package com.example.cuentosfrontend

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cuentosfrontend.screens.LoginScreen
import com.example.cuentosfrontend.screens.ChosseAvatarScreen
import com.example.cuentosfrontend.screens.HomeScreen
import com.example.cuentosfrontend.ui.theme.CuentosFrontendTheme




class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            CuentosFrontendTheme {
                AppNavHost()
            }
        }
    }


    @Composable
    fun AppNavHost() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginScreen(navController)
            }
            composable(
                route = "choose_avatar/{username}",
                arguments = listOf(navArgument("username") { type = NavType.StringType })
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                ChosseAvatarScreen(navController, username)
            }
            composable(
                //Defines una ruta para la pantalla HomeScreen
                route = "HomeScreen/{username}/{avatarId}",//avatarid indica que es un parámetro dinámico que la ruta espera recibir
                //Declara que esta ruta espera un argumento llamado "avatarId"
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("avatarId") { type = NavType.IntType }
                )
                //El bloque que se ejecuta cuando navegas a esta ruta
            ) { backStackEntry ->
                //Aquí extraemos el argumento "avatarId" que se pasó en la ruta.
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val avatarId =
                    backStackEntry.arguments?.getInt("avatarId") ?: R.drawable.perfil_dragon
                HomeScreen(
                    username = username,
                    avatarId = avatarId,
                    navController = navController,
                )
            }

        }
    }
}