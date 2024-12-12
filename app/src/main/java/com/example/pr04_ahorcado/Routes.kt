package com.example.pr04_ahorcado

sealed class Routes(val route: String) {
    object vistaMenu : Routes("vistaMenu")
    object Juego : Routes("vistaJuego")
    object Result : Routes("vistaResult")
    object splash : Routes("vistaSplash")
}