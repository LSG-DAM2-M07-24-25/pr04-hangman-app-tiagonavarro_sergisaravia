package com.example.pr04_ahorcado.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.pr04_ahorcado.model.ahorcado
import com.example.pr04_ahorcado.viewmodel.menuViewModel.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.R
import com.example.pr04_ahorcado.viewmodel.menuViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.Navigation
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

            // Text Display
            Text(
                text = "Welcome to the App!",
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
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
                    .padding(9.dp),
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
                        text = { Text(text = dificultad, color = Color.White) },
                        onClick = {
                            expanded = false
                            selectedText = dificultad
                            myviewModel.selectDificutad.value = dificultad
                            myviewModel.onDificultSelected()
                        }
                    )
                }
            }

            // Buttons
            Button(
                onClick = { navController.navigate(Routes.Juego.route) },
                modifier = Modifier.padding(top = 120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Play")
            }
            Button(
                onClick = { navController.navigate(Routes.Help.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Help")
            }
        }
    }
}
