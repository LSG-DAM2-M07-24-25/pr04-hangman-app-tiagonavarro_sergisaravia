package com.example.m07uf1pr01tiagonavarrosergisaravia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.navigation.NavHostController
import com.example.m07uf1pr01tiagonavarrosergisaravia.ui.theme.M07UF1PR01TiagoNavarroSergiSaraviaTheme

class SegonaPantalla(navigationController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M07UF1PR01TiagoNavarroSergiSaraviaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScndIconBackground(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScndIconBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.descarga),
            contentDescription = "Descripció",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScndIconBackgroundPreview() {
    M07UF1PR01TiagoNavarroSergiSaraviaTheme {
        ScndIconBackground()
    }
}