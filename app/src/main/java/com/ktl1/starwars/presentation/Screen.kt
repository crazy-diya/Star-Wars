package com.ktl1.starwars.presentation

sealed class Screen(val route: String){
    object PlanetListScreen: Screen("planet_list_screen")
    object PlanetDetailsScreen: Screen("planet_details_screen")

}
