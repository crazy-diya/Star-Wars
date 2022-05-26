package com.ktl1.starwars.data.remote.dto

import com.ktl1.starwars.domain.model.Planets

data class PlanetsDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PlanetDto>
)

fun PlanetsDto.toPlanets(): Planets {
    return Planets(results = results)
}