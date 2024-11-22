package com.example.m07uf1pr01tiagonavarrosergisaravia.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.m07uf1pr01tiagonavarrosergisaravia.Routes

@Composable
fun Screen1(navController: NavController) {
    ScreenTemplate(
        navController = navController,
        backgroundColor = Color.Magenta,
        text = "Pantalla 1", // Canviat a Pantalla 1
        nextRoute = Routes.Screen2
    )
}
