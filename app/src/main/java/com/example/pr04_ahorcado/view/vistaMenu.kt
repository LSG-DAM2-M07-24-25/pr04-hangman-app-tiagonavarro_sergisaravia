package com.example.pr04_ahorcado.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pr04_ahorcado.viewmodel.menuViewModel.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pr04_ahorcado.R
import com.example.pr04_ahorcado.viewmodel.menuViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.pr04_ahorcado.Routes

@Composable
fun vistaMenu(myviewModel: menuViewModel, navController: NavController) {
    val iconoAplicacion = painterResource(id = R.drawable.iconoapp)
    val scrollState = rememberScrollState()
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var textFieldPosition by remember { mutableStateOf(Offset.Zero) }
    val density = LocalDensity.current // To convert pixels to Dp
    var showDialog by remember{ mutableStateOf(false)}
    
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    val options = listOf("facil", "moderado", "dificil", "imposible")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Red),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                )
            )
    ) {
        Column(
            modifier = Modifier
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
                    .size(300.dp)
                    .padding(30.dp),
                contentScale = ContentScale.Fit
            )

            // OutlinedTextField
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                        textFieldPosition = coordinates.positionInWindow()
                    }
                    .clickable { expanded = true }
                    .padding(25.dp),
                label = { Text(text = "Selecciona dificultad") },
                trailingIcon = {
                    Icon(icon, "", Modifier.clickable { expanded = true })
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black
                )
            )

            // DropdownMenu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = with(density) {
                    DpOffset(
                        x = textFieldPosition.x.toDp(), // Convert X position to Dp
                        y = (textFieldPosition.y + textFieldSize.height).toDp() // Position below the field
                    )
                }
            ) {
                options.forEach { dificultad ->
                    DropdownMenuItem(
                        text = { Text(text = dificultad, color = Color.Black) },
                        onClick = {
                            expanded = false
                            selectedText = dificultad
                            myviewModel.onDificultSelected(dificultad)
                        }
                    )
                }
            }

            // Buttons
            Button(
                onClick = {
                    myviewModel.resetGame()
                    navController.navigate(Routes.Juego.route) },
                modifier = Modifier.padding(top = 120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Play")
            }
            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Help")
            }
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    // Permite cerrar el diálogo al tocar fuera del cuadro
                    showDialog = false
                },
                title = {
                    Text(text = "Ahorcado")
                },
                text = {
                    // Contenido scrollable
                    Box(
                        modifier = Modifier
                            .height(200.dp) // Altura máxima para permitir scroll si el contenido es mayor
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = "Reglas: \n\n" +
                                    "\t 1. Selecciona la letra que creas que falte en la palabra \n" +
                                    "\t 2. Cada vez que fallas un dibujo de un stickman ahorcada se irá haciendo pieza a pieza \n" +
                                    "\t 3. Si adivinas todas las letras antes de que el dibujo del stickman se complete ganas \n" +
                                    "\t 4. Si el dibujo del stickman se completa pierdes \n\n\n" +
                                    "Si ganas: \n\n" +
                                    "\t 1. Se sumará un punto a tu puntuación \n" +
                                    "\t 2. Te saldrá una nueva palabra para completar \n" +
                                    "\t 3. El dibujo del ahorcada se reiniciara restableciendo tu numero de intentos \n\n\n" +
                                    "Si pierdes: \n\n" +
                                    "\t 1. Te enviará a una pantalla donde veras tu puntuación donde decidiras si volver a jugar (con la misma dificultad) o volver al menú \n\n\n" +
                                    "Dificultades: \n\n" +
                                    "\t 1. Selecciona la dificultad en el dropdown del menu \n" +
                                    "\t 2. Hay cuatro dificultades (facil, moderado, dificil e imposible) \n" +
                                    "\t 3. La dificultad va segun la longitud de la palabra: facil de 3 a 4 letras, moderado de 5 a 6 letras, dificil de 7 a 8 letra e imposibre de 9 a 10 letras"
                        )
                    }
                },
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        onClick = {
                            // Acción al cerrar
                            showDialog = false
                        }
                    ) {
                        Text("Cerrar")
                    }
                }
            )
        }
    }
}
