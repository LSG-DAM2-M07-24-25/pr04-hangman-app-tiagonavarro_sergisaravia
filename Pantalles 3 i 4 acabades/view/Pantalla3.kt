@file:Suppress("UNREACHABLE_CODE")

package com.example.livedataexample.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livedataexample.R
import com.example.livedataexample.Routes
import com.example.livedataexample.ui.theme.LiveDataExampleTheme
import kotlinx.coroutines.delay

//Pantalla3
class Pantalla2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveDataExampleTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost2()
                }
            }
        }
    }
}

@Composable
fun MainNavHost2() {
    val navController = rememberNavController() // Controlador de navegació
    NavHost(
        navController = navController,
        startDestination = "screen3" // Pantalla inicial
    ) {
        composable("screen3") {
            Screen3(navController = navController, roundsWon = 0)
        }
        composable("numberview") {
            Final(
                navController = navController
            )
        }
    }
}


@Composable
fun Screen3(navController: NavController, roundsWon: Int) {
    val wordsList = arrayOf(
        "CASA", "GAT", "GOS", "TAULA", "CADIRA", "COTXE", "FLOR", "NÚVOL", "MUNTANYA", "PLATJA",
        "MAR", "AIGUA", "SOL", "LLUNA", "ESTRELLA", "CARRER", "ESCOLA", "LLIBRE", "BOLÍGRAF",
        "TREBALL", "AMISTAT", "FESTA", "MÚSICA", "JARDÍ", "FAMÍLIA", "CIUTAT", "TREN", "AVENTURA",
        "MISTERI", "POEMA", "PLANETA", "PAÍS", "CASTELL", "GUITARRA", "CINEMA", "TEATRE"
    )

    var hangmanWord by rememberSaveable { mutableStateOf(wordsList.random()) }
    var startHangmanArray by rememberSaveable { mutableStateOf(hangmanWord.map { '_' }.toMutableList()) }
    var selectedKey by rememberSaveable { mutableStateOf<Char?>(null) }
    var selectedKeys by rememberSaveable { mutableStateOf(setOf<Char>()) }
    var gameOver by rememberSaveable { mutableStateOf(false) }
    var win by rememberSaveable { mutableStateOf(false) }
    var attemptsLeft by rememberSaveable { mutableStateOf(6) }

    selectedKey?.let { key ->
        if (!gameOver) {
            if (key in hangmanWord && key !in selectedKeys) {
                startHangmanArray = startHangmanArray.mapIndexed { index, current ->
                    if (hangmanWord[index] == key) key else current
                }.toMutableList()
                if (!startHangmanArray.contains('_')) {
                    win = true
                    gameOver = true
                    ScoreManager.incrementRoundsWon() // Incrementar rondes guanyades
                }
            } else if (key !in selectedKeys) {
                attemptsLeft--
                if (attemptsLeft <= 0) { // Game over si no queden intents
                    gameOver = true
                }
            }
            selectedKeys = selectedKeys + key
        }
        selectedKey = null
    }

    // Interfície d'usuari
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            // Imatges del penjat segons els intents restants
            if (attemptsLeft == 6) {
                Image(
                    painter = painterResource(id = R.drawable.hangman6),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 5) {
                Image(
                    painter = painterResource(id = R.drawable.hangman5),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 4) {
                Image(
                    painter = painterResource(id = R.drawable.hangman4),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 3) {
                Image(
                    painter = painterResource(id = R.drawable.hangman3),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 2) {
                Image(
                    painter = painterResource(id = R.drawable.hangman2),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 1) {
                Image(
                    painter = painterResource(id = R.drawable.hangman1),
                    contentDescription = "Penjat"
                )
            } else if (attemptsLeft == 0) {
                Image(
                    painter = painterResource(id = R.drawable.hangman0),
                    contentDescription = "Penjat"
                )
            }
        }

        Text(
            text = startHangmanArray.joinToString(" "),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Intent restants: $attemptsLeft",
            fontSize = 18.sp,
            color = Color.Black
        )

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
                                    isSelected && charKey in hangmanWord -> Color.Green
                                    isSelected -> Color.Red
                                    else -> Color.Gray
                                },
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable(
                                enabled = !isSelected && !gameOver,
                                onClick = { selectedKey = charKey }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = key, color = Color.White, fontSize = 12.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Redirecció al final del joc
        if (gameOver) {
            val result = if (win) "Guanyat" else "Perdut"
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(Routes.Final.route) {
                    popUpTo("screen3") { inclusive = true }
                }
            }
        }

        if (gameOver) {
            val result = if (win) "Guanyat" else "Perdut"
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(Routes.Final.route)
            }
        }
    }
}

