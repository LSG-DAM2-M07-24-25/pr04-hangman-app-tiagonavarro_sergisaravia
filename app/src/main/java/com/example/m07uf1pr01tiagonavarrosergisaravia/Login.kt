package com.example.m07uf1pr01tiagonavarrosergisaravia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.m07uf1pr01tiagonavarrosergisaravia.ui.theme.M07UF1PR01TiagoNavarroSergiSaraviaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M07UF1PR01TiagoNavarroSergiSaraviaTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        IconBackground(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun IconBackground(navController: NavController?, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.icono),
            contentDescription = "Descripció",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .clickable
                { navController?.navigate(Routes.SegonaPantalla.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    M07UF1PR01TiagoNavarroSergiSaraviaTheme {
        LoginScreen()
    }
}
