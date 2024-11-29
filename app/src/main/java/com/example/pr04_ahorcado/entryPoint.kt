package com.example.pr04_ahorcado

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.R
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pr04_ahorcado.view.Routes

@Composable

fun entryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Menu.route
    ){
        composable(Routes.Menu.route) { Routes.Menu(navigationController) }
        composable(Routes.Menu.route) { Routes.Help(navigationController) }
        composable(Routes.Juego.route){ Routes.Juego(navigationController)}
    }
}