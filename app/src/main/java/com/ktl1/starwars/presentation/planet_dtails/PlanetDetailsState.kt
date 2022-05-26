package com.ktl1.starwars.presentation.planet_dtails

import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.domain.model.Planet
import com.ktl1.starwars.domain.model.Planets

data class PlanetDetailsState(
    val isLoading: Boolean = false,
    val planetDetails: Planet? = null,
    val error: String = ""
)
