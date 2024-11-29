@file:Suppress("UNREACHABLE_CODE")

package com.example.livedataexample.view
//Pantalla2
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livedataexample.Routes
import com.example.livedataexample.ui.theme.LiveDataExampleTheme

class Pantalla3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveDataExampleTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost3()
                }
            }
        }
    }
}

@Composable
fun MainNavHost3() {
    val navController = rememberNavController() // Controlador de navegació
    NavHost(
        navController = navController,
        startDestination = "screen1" // Pantalla inicial
    ) {
        // Definim les rutes i associem cada ruta amb un Composable
        composable("screen2") {
            Screen2(
                navController = TODO()
            )
        }
        composable("screen3") {
            Screen3(
                navController = TODO()
            )
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(
            text = "Pantalla 2",
            modifier = Modifier
                .clickable
                { navController.navigate(Routes.Pantalla3.route) })
    }
}

