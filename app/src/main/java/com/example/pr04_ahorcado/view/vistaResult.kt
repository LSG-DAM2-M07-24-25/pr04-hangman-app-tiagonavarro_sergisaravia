package com.example.pr04_ahorcado.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr04_ahorcado.Routes
import com.example.pr04_ahorcado.viewmodel.menuViewModel


@Composable
fun vistaResult(myviewModel : menuViewModel, navController: NavController) {
    val rondasGanadasCount by myviewModel.rondasGanadas.observeAsState(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Red),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rondas ganadas: ${rondasGanadasCount}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Opció de sortir o reiniciar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    myviewModel.resetPuntuacion()
                    navController.navigate(Routes.Juego.route)
                },// Pantalla de sortida
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),

                ) {
                Text(text = "Volver ha jugar")
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {
                    myviewModel.resetPuntuacion()
                    navController.navigate(Routes.vistaMenu.route)
                },// Pantalla de sortida
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),

            ) {
                Text(text = "Salir")
            }
        }
    }
}