package com.ktl1.starwars.presentation.planet_dtails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ktl1.starwars.data.remote.dto.toPlanet
import com.ktl1.starwars.presentation.Screen
import com.ktl1.starwars.presentation.planet_list.component.PlanetListItem

@Composable
fun PlanetDetailsScreen(
    viewModel: PlanetDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.planetDetails?.let { planet ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(25.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(25.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = planet.name,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = planet.orbital_period,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = planet.gravity,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
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