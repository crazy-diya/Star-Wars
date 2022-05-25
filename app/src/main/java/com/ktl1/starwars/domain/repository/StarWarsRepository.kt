package com.ktl1.starwars.domain.repository

import com.ktl1.starwars.data.remote.dto.PlanetDto
import com.ktl1.starwars.data.remote.dto.PlanetsDto

interface StarWarsRepository {
    suspend fun getAllPlanets(): PlanetsDto
    suspend fun getPlanetById(id:String) : PlanetDto
}