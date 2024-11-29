package com.example.pr04_ahorcado.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pr04_ahorcado.Routes

@Composable
fun vistaMenu(myviewModel : menuViewModel, navController: NavController) {
    val iconoAplicacion = painterResource(id = R.drawable.iconoapp)
    val scrollState = rememberScrollState()
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("facil", "moderado", "dificil", "imposible")
    var hola by remember { mutableStateOf("h") }

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

        OutlinedTextField(
            value = selectedText,
            trailingIcon = {Icon(
                imageVector = Icons.Filled.ArrowDropDown, // Usamos un ícono de Material Design
                contentDescription = "Dropdown Icon",
                tint = Color.Gray
            )},
            onValueChange = {selectedText = it},
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable{ expanded = true }
                .padding(9.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach() { dificultad ->
                DropdownMenuItem(text = { Text(text = dificultad)},
                    onClick = {
                        expanded = false
                        selectedText = dificultad
                        myviewModel.selectDificutad.value = dificultad
                        myviewModel.onDificultSelected()
                    })
            }
        }
        /*
        Button(
            onClick =
        ){
            Text(text = "Play")
        }
        Button(
            onClick = 
        ){
            Text(text = "Help")
        }*/
    }
}