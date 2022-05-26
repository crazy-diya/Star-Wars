package com.ktl1.starwars.data.repository

import com.ktl1.starwars.data.remote.StarWarsApi
import com.ktl1.starwars.data.remote.dto.PlanetDto
import com.ktl1.starwars.data.remote.dto.PlanetsDto
import com.ktl1.starwars.domain.repository.StarWarsRepository
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val api: StarWarsApi
) : StarWarsRepository {
    override suspend fun getAllPlanets(): PlanetsDto {
        return api.getAllPlanets()
    }

    override suspend fun getPlanetById(id: String): PlanetDto {
        return  api.getPlanetById(id)
    }
}