package com.example.m07uf1pr01tiagonavarrosergisaravia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m07uf1pr01tiagonavarrosergisaravia.view.Screen1
import com.example.m07uf1pr01tiagonavarrosergisaravia.view.Screen2
import com.example.m07uf1pr01tiagonavarrosergisaravia.view.Screen3
import com.example.m07uf1pr01tiagonavarrosergisaravia.view.Screen4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.Screen1) {
                composable(Routes.Screen1) { Screen1(navController) }
                composable(Routes.Screen2) { Screen2(navController) }
                composable(Routes.Screen3) { Screen3(navController) }
                composable(Routes.Screen4) { Screen4(navController) }
            }
        }
    }
}
