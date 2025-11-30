package com.example.cuentosfrontend



import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cuentosfrontend.screens.ChosseAvatarScreen
import com.example.cuentosfrontend.ui.screens.HomeScreen
import com.example.cuentosfrontend.ui.theme.CuentosFrontendTheme




class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuentosFrontendTheme {
                HomeScreen()
            }
        }
    }
}
    /*@RequiresApi(Build.VERSION_CODES.P)
    @Composable
    fun AppNavHost() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "choose_avatar/demoUser/EN"
        ) {
        //NavHost(navController = navController, startDestination = "login") {
            /*composable("login") {
                LoginScreen(navController)
            }*/

            composable(
                route = "choose_avatar/{username}/{language}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("language") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val language = backStackEntry.arguments?.getString("language") ?: ""
                ChosseAvatarScreen(navController, username, language)
            }/*
            composable(
                route = "HomeScreen/{username}/{language}/{avatarId}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("language") { type = NavType.StringType },
                    navArgument("avatarId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val language = backStackEntry.arguments?.getString("language") ?: "Español"
                val avatarId =
                    backStackEntry.arguments?.getInt("avatarId") ?: R.drawable.dragon_estatico

                HomeScreen(
                    username = username,
                    language = language,
                    avatarId = avatarId,
                    navController = navController
                )
            }

            composable(
                route = "ModificarPerfil/{username}/{language}/{avatarIdInicial}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("language") { type = NavType.StringType },
                    navArgument("avatarIdInicial") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val language = backStackEntry.arguments?.getString("language") ?: "Español"
                val avatarIdInicial = backStackEntry.arguments?.getInt("avatarIdInicial") ?: R.drawable.dragon_estatico

                ModificarPerfil(
                    navController = navController,
                    username = username,
                    language = language,
                    avatarIdInicial = avatarIdInicial
                )
            }
            composable(
                route = "choosemodif_avatar/{username}/{language}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("language") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val language = backStackEntry.arguments?.getString("language") ?: ""
                ChosseAvatarScreenModif(navController, username, language)
            }


            composable(
                route = "cuento/{cuentoId}",
                arguments = listOf(navArgument("cuentoId") { type = NavType.StringType })
            ) { backStackEntry ->
                val cuentoId = backStackEntry.arguments?.getString("cuentoId") ?: ""
                ChosseMode(navController, cuentoId)
            }*/
        }
    }
}
*/