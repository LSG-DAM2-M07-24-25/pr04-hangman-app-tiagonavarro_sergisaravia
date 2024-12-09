package com.example.pr04_ahorcado.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pr04_ahorcado.Routes
import kotlinx.coroutines.delay

//TODO hacer que se inicialicen las variables
@Composable
fun vistaJuego(
    myviewModel : menuViewModel, navController: NavController
) {

    val wordState by myviewModel.wordState
    val selectedKeys by myviewModel.selectedKeys
    val gameOver by myviewModel.gameOver
    val win by myviewModel.win
    val attemptsLeft by myviewModel.attemptsLeft




    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            val hangmanImages = listOf(
                R.drawable.hangman6,
                R.drawable.hangman5,
                R.drawable.hangman4,
                R.drawable.hangman3,
                R.drawable.hangman2,
                R.drawable.hangman1,
                R.drawable.hangman0,

            )
            Image(
                painter = painterResource(id = hangmanImages[6 - attemptsLeft]),
                contentDescription = "Hangman"
            )
        }
        Text(text = wordState.joinToString(" "), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Intent restants: $attemptsLeft", fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))

        val keys = listOf(
            listOf("A", "B", "C", "Ç", "D", "E", "F", "G", "H"),
            listOf("I", "J", "K", "L", "M", "N", "O", "P", "Q"),
            listOf("R", "S", "T", "U", "V", "W", "X", "Y", "Z")
        )
        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    val charKey = key[0]
                    val isSelected = charKey in selectedKeys
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                when {
                                    isSelected && charKey in wordState -> Color.Green
                                    isSelected -> Color.Red
                                    else -> Color.Gray
                                },
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable(
                                enabled = !isSelected && !gameOver,
                                onClick = { myviewModel.selectKey(charKey) }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = key, color = Color.White, fontSize = 12.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        if (gameOver && !win) {
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(Routes.Result.route)
            }
        } else {
            myviewModel.resetGame()
        }
    }
}
