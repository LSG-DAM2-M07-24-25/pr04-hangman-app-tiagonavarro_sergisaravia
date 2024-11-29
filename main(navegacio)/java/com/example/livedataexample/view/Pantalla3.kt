@file:Suppress("UNREACHABLE_CODE")

package com.example.livedataexample.view

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livedataexample.Routes
import com.example.livedataexample.ui.theme.LiveDataExampleTheme
//Pantalla3
class Pantalla2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveDataExampleTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost2()
                }
            }
        }
    }
}

@Composable
fun MainNavHost2() {
    val navController = rememberNavController() // Controlador de navegació
    NavHost(
        navController = navController,
        startDestination = "screen3" // Pantalla inicial
    ) {
        // Definim les rutes i associem cada ruta amb un Composable
        composable("screen3") {
            Screen3(
                navController = TODO()
            )
        }
        composable("numberview") {
            Body(
                myViewModel = TODO()
            )
        }
    }
}

@Composable
fun Screen3(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(
            text = "Pantalla 3",
            modifier = Modifier
                .clickable
                { navController.navigate(Routes.NumberView.route) })

    }
}

