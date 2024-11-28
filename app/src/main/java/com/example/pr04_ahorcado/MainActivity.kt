package com.example.pr04_ahorcado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//importar vistas creadas
import com.example.pr04_ahorcado.view.*
//importar todos los view models creados
import com.example.pr04_ahorcado.viewmodel.*
import androidx.activity.viewModels;
import com.example.pr04_ahorcado.R


class MainActivity : ComponentActivity() {
    val menuViewModel: menuViewModel by viewModels<menuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            mainMenu()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainMenu(modifier: Modifier = Modifier) {
    val iconoAplicacion = painterResource(id = R.drawable.iconoapp)
    val scrollState = rememberScrollState()
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val dificultades = listOf("Facil", "Moderado", "Dificil", "Leyenda")
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image Display
        Image(
            painter = iconoAplicacion,
            contentDescription = "App Icon",
            modifier = Modifier
                .size(300.dp) // Set a fixed size
                .padding(8.dp),
            contentScale = ContentScale.Fit // Avoid cropping
        )

        // Text Display
        Text(
            text = "Welcome to the App!",
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            dificultades.forEach { dificultad ->
                DropdownMenuItem(text = { Text(text = dificultad)},
                    onClick = {
                        expanded = false
                        selectedText = dificultad
                    })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    mainMenu()
}