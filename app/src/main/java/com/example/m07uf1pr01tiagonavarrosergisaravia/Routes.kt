package com.example.m07uf1pr01tiagonavarrosergisaravia

sealed class Routes(val route: String) {
    object Login:Routes("login")
    object SegonaPantalla:Routes("segonapantalla")
}