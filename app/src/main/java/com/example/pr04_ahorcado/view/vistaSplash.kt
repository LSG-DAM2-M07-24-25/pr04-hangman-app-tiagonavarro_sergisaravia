package com.example.livedataexample.view
//Pantalla1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.pr04_ahorcado.R
import com.example.pr04_ahorcado.Routes



@Composable
fun vistaSplash(navController: NavController) {
    // Canvia de pantalla automàticament al cap de 3 segons
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Routes.vistaMenu.route)
    }

    // Disseny de la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Image(
            painter = painterResource(id = R.drawable.iconoapp),
            contentDescription = "Descripció",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
//d

