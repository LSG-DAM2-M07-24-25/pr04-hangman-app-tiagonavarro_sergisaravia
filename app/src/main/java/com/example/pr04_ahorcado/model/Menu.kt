package com.example.pr04_ahorcado.model

data class ahorcado(
    var dificultad: Int,
    val wordsList: List<String> = listOf(
        "CASA", "GAT", "GOS", "TAULA", "CADIRA", "COTXE", "FLOR", "NÚVOL", "MUNTANYA", "PLATJA",
        "MAR", "AIGUA", "SOL", "LLUNA", "ESTRELLA", "CARRER", "ESCOLA", "LLIBRE", "BOLÍGRAF",
        "TREBALL", "AMISTAT", "FESTA", "MÚSICA", "JARDÍ", "FAMÍLIA", "CIUTAT", "TREN", "AVENTURA",
        "MISTERI", "POEMA", "PLANETA", "PAÍS", "CASTELL", "GUITARRA", "CINEMA", "TEATRE"
    ),
    val maxAttemts: Int = 6
){
    private lateinit var currentWord: String
    private val selectedKeys: MutableSet<Char> = mutableListOf()
    private var attemptsLeft: Int = maxAttemts
    private var gameOver: Boolean = false
    private var win: Boolean = false

    fun resetGame() {
        currentWord = wordsList.random()
        currentWord
    }
}

