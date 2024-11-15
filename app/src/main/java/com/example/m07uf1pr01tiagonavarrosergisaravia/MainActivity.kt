package com.example.m07uf1pr01tiagonavarrosergisaravia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.SegonaPantalla.route) { SegonaPantalla(navigationController) }

    }
}
