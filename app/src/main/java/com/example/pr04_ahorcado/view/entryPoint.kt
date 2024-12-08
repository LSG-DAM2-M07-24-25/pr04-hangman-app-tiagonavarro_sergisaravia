package com.example.pr04_ahorcado

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.livedataexample.view.vistaSplash
import com.example.pr04_ahorcado.Routes
import com.example.pr04_ahorcado.view.vistaJuego
import com.example.pr04_ahorcado.view.vistaHelp
import com.example.pr04_ahorcado.view.vistaMenu
import com.example.pr04_ahorcado.view.vistaResult
import com.example.pr04_ahorcado.viewmodel.menuViewModel

@Composable

fun entryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.splash.route
    ){
        composable(Routes.vistaMenu.route) { vistaMenu(menuViewModel(), navigationController)}
        composable(Routes.Help.route) { vistaHelp(menuViewModel(), navigationController) }
        composable(Routes.Juego.route){ vistaJuego(menuViewModel(), navigationController) }
        composable(Routes.Result.route){ vistaResult(menuViewModel(), navigationController)}
        composable(Routes.splash.route){ vistaSplash(navigationController)}
    }
}