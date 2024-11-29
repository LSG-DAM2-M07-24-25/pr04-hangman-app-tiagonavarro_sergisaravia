package com.example.pr04_ahorcado.view

sealed class Routes(val route: String) {
    object Menu : Routes("vistaMenu.kt")
    object Juego : Routes("vistaJuego.kt")
    object Help : Routes("vistaHelp.kt")
}