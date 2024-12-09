package com.example.livedataexample.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr04_ahorcado.Routes
import com.example.pr04_ahorcado.view.ScoreManager


@Composable
fun Final(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rondes guanyades: ${ScoreManager.roundsWon}",
            fontSize = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Opció de sortir o reiniciar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Vols tornar a jugar?",
                modifier = Modifier
                    .clickable {
                        ScoreManager.reset() // Reset de les rondes
                        navController.navigate(Routes.Juego.route) // Tornar a la pantalla inicial
                    }
                    .background(Color.Blue, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp),
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Sortir",
                modifier = Modifier
                    .clickable {
                        navController.navigate(Routes.vistaMenu.route) // Pantalla de sortida
                    }
                    .background(Color.Red, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp),
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}