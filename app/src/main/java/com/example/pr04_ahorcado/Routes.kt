package com.example.pr04_ahorcado

sealed class Routes(val route: String) {
    object vistaMenu : Routes("vistaMenu")
    object Juego : Routes("vistaJuego")
    object Help : Routes("vistaHelp")
}