package com.example.livedataexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// Per poder usar el MVVM
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import androidx.viewbinding.ViewBinding
import com.example.livedataexample.ui.theme.LiveDataExampleTheme
// Per importar totes les vistes creades
import com.example.livedataexample.view.*
// Per importar tots els ViewModels creats
import com.example.livedataexample.viewmodel.*
//MainActivity
class MainActivity : ComponentActivity() {
    // Definim la constant que farà referència al View Model declarat
    val numeroViewModel: NumeroViewModel by viewModels<NumeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LiveDataExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }

            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.Pantalla1.route
            ) {
                composable(Routes.Pantalla1.route) { ScreenSplash(navigationController) }
                composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                composable(Routes.Pantalla3.route) { Screen3(navigationController, roundsWon = 0) }
                composable(Routes.Final.route) { Final(navigationController)
                }
            }
        }
    }
}