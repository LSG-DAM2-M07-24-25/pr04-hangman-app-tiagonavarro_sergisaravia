package com.example.livedataexample.view

object ScoreManager {
    var roundsWon: Int = 0
        private set

    // Funció per incrementar les rondes guanyades
    fun incrementRoundsWon() {
        roundsWon++
    }

    // Funció per resetar les rondes guanyades
    fun reset() {
        roundsWon = 0
    }
}



