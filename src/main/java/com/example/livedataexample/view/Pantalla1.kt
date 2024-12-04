@file:Suppress("UNREACHABLE_CODE")

package com.example.livedataexample.view
//Pantalla1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livedataexample.R
import com.example.livedataexample.Routes
import com.example.livedataexample.ui.theme.LiveDataExampleTheme

class SplashScreen : ComponentActivity() {
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
            ScreenSplash(
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
fun ScreenSplash(navController: NavController) {
    // Canvia de pantalla automàticament al cap de 3 segons
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Routes.Pantalla2.route)
    }

    // Disseny de la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icono_app),
            contentDescription = "Descripció",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


