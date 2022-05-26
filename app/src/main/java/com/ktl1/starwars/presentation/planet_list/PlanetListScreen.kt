package com.ktl1.starwars.presentation.planet_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ktl1.starwars.data.remote.dto.toPlanet
import com.ktl1.starwars.presentation.Screen
import com.ktl1.starwars.presentation.planet_list.component.PlanetListItem

@Composable
fun PlanetListScreen(
    navController: NavController,
    viewModel: PlanetListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Box(
                    modifier = Modifier
                        .fillParentMaxWidth()

                ) {
                    Text(
                        text = "StarWar Planet List!",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = 25.dp),
                    )
                }
            }
            state.planetList?.let {

                println(it.results.size)
                items(it.results.size) { planet ->
                    println(planet)
                    PlanetListItem(
                        planet = it.results[planet].toPlanet(),
                        onItemClick = {
                            navController.navigate(Screen.PlanetDetailsScreen.route + "/${planet+1}")
                        }

                    )
                    println("Done")
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}