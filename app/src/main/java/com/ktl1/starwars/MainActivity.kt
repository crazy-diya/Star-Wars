package com.ktl1.starwars

import StarWarsAppYTTheme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktl1.starwars.presentation.Screen
import com.ktl1.starwars.presentation.planet_dtails.PlanetDetailsScreen
import com.ktl1.starwars.presentation.planet_list.PlanetListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter =  painterResource(id = R.drawable.sunflower)
            StarWarsAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PlanetListScreen.route
                    ) {
                        composable(
                            route = Screen.PlanetListScreen.route
                        ) {
                            PlanetListScreen(navController)
                        }
                        composable(
                            route = Screen.PlanetDetailsScreen.route + "/{id}"
                        ) {
                            PlanetDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}