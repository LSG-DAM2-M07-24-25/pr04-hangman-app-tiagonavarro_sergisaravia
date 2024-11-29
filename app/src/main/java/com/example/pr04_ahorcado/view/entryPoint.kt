package com.example.pr04_ahorcado

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.R
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pr04_ahorcado.Routes
import com.example.pr04_ahorcado.view.Menu
import com.example.pr04_ahorcado.view.vistaMenu
import com.example.pr04_ahorcado.viewmodel.menuViewModel

@Composable

fun entryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.vistaMenu.route
    ){
        composable(Routes.vistaMenu.route) { vistaMenu(menuViewModel(), navigationController)}
        composable(Routes.Help.route) { Routes.Help(navigationController) }
        composable(Routes.Juego.route){ Routes.Juego(navigationController)}
    }
}