package com.example.cuentosfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cuentosfrontend.screens.LoginScreen
import com.example.cuentosfrontend.screens.ChosseAvatarScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    }

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("choose_avatar") {
            ChosseAvatarScreen(navController)
        }
    }
}

