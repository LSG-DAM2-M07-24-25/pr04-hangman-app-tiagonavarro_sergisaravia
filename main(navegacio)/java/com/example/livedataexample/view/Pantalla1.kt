@file:Suppress("UNREACHABLE_CODE")

package com.example.livedataexample.view
//Pantalla1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livedataexample.Routes
import com.example.livedataexample.ui.theme.LiveDataExampleTheme

class Pantalla1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveDataExampleTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost()
                }
            }
        }
    }
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController() // Controlador de navegació
    NavHost(
        navController = navController,
        startDestination = "screen1" // Pantalla inicial
    ) {
        // Definim les rutes i associem cada ruta amb un Composable
        composable("screen1") {
            Screen1(
                navController = TODO()
            )
        }
        composable("screen2") {
            Screen2(
                navController = TODO()
            )
        }
    }
}

@Composable
fun Screen1(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier
                .clickable
                { navController.navigate(Routes.Pantalla2.route) })

    }
}

