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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pr04_ahorcado.Routes

@Composable
fun vistaHelp(myviewModel : menuViewModel, navController: NavController){
    val scrollState = rememberScrollState()
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
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 55.dp)
                .padding(horizontal = 25.dp)
                .background(Color.Red)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row(){
                Text(
                    text="Help",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold

                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="1. Objective:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ){
                Icon(Icons.Filled.Star, contentDescription = "star", modifier = Modifier.size(12.dp))
                Text(
                    text="The goal of the game is to guess the hidden word or phrase by suggesting letters one at a time. You win if you guess the word correctly before the hangman figure is fully drawn.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="2. Setup:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ){
                Icon(Icons.Filled.Star, contentDescription = "star", modifier = Modifier.size(12.dp))
                Text(
                    text="Choose or generate a word or phrase for the game.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "Write blank spaces to represent each letter of the word. Spaces between words should be left blank.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "Keep track of the letters you’ve already guessed.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="3. Gameplay:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "On each turn, guess one letter. If the letter is in the word, fill it in the appropriate blank spaces.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "If the letter is not in the word, increase the number of incorrect guesses.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "You can also choose to guess the entire word or phrase, but if it's wrong, it counts as an incorrect guess.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="4. Limit on Incorrect Guesses:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "You have a limited number of incorrect guesses (usually 6 or 7) before the hangman is fully drawn.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "Each incorrect guess adds a part to the figure (head, body, arms, legs, etc.).",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="5. Winning the game",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "You win if you guess all the letters of the word or phrase before the hangman is fully drawn.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "The word is revealed, and you’ve won the game if you’ve successfully guessed all letters.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text="6. Losing the game:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "You win if you guess all the letters of the word or phrase before the hangman is fully drawn.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "The game ends in a loss if the hangman is fully drawn before you’ve guessed the word or phrase.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .padding(bottom = 30.dp)
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "star",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "The game shows the completed word or phrase after you lose.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }


        }
    }
}