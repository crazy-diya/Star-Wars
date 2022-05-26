package com.ktl1.starwars.domain.model

import com.ktl1.starwars.data.remote.dto.PlanetDto
import com.ktl1.starwars.data.remote.dto.PlanetsDto

data class Planets(
    val results: List<PlanetDto> = emptyList(),
)
