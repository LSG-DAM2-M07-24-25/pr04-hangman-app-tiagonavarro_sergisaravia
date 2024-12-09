package com.example.pr04_ahorcado.model

import androidx.compose.runtime.key

data class ahorcado(
    var dificultad: Int = 1,
    val wordsList: List<String> = listOf(
        "CASA", "GAT", "GOS", "TAULA", "CADIRA", "COTXE", "FLOR", "NÚVOL", "MUNTANYA", "PLATJA",
        "MAR", "AIGUA", "SOL", "LLUNA", "ESTRELLA", "CARRER", "ESCOLA", "LLIBRE", "BOLÍGRAF",
        "TREBALL", "AMISTAT", "FESTA", "MÚSICA", "JARDÍ", "FAMÍLIA", "CIUTAT", "TREN", "AVENTURA",
        "MISTERI", "POEMA", "PLANETA", "PAÍS", "CASTELL", "GUITARRA", "CINEMA", "TEATRE"
    ),
    val maxAttemts: Int = 6
){
    private var currentWord: String = wordsList.random()
    private var currentWordArray:  MutableList<Char> = currentWord.map {'_'}.toMutableList()
    private val selectedKeys: MutableSet<Char> = mutableSetOf()
    private var attemptsLeft: Int = maxAttemts
    private var gameOver: Boolean = false
    private var win: Boolean = false
    private var rondasGanadas: Int = 0

    fun resetGame() { //metodo para reiniciar juego
        currentWord = wordsList.random() //elije una palabra random del array
        currentWordArray = currentWord.map {'_'}.toMutableList() //devuelve todos los datos para que se printeen como '_'
        selectedKeys.clear()
        attemptsLeft = maxAttemts
        gameOver = false
        win = false
        rondasGanadas = 0
    }

    //Metodos get
    fun getWordState(): List<Char> = currentWordArray
    fun getAttemptsLeft(): Int = attemptsLeft
    fun getRondasGanadas(): Int = rondasGanadas
    fun isGameOver(): Boolean = gameOver
    fun didWin(): Boolean = win

    fun selectKey(key : Char) {
        if (gameOver || selectedKeys.contains(key)) return
        selectedKeys.add(key)
        if (key in currentWord) {
            currentWordArray = currentWordArray.mapIndexed { index, existingChar ->
                if (existingChar != '_') existingChar
                else if (currentWord[index] == key) key
                else '_'
            }.toMutableList()

        }
        if (!currentWordArray.contains('_')) { //comprueba que no hay ningun '_' por lo tanto el jugador habria ganado
            win = true
            rondasGanadas++
            gameOver = true
        } else {
            attemptsLeft--
            if (attemptsLeft <= 0){
                gameOver = true
                win = false
            }
        }
    }

    fun getSelectedKeys(): Set <Char> = selectedKeys

}

