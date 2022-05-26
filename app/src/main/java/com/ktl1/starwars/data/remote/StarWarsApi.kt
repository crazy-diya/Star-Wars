package com.ktl1.starwars.data.remote

import com.ktl1.starwars.data.remote.dto.PlanetDto
import com.ktl1.starwars.data.remote.dto.PlanetsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {
    @GET("planets/")
    suspend fun getAllPlanets():PlanetsDto

    @GET("planets/{id}")
    suspend fun getPlanetById(@Path("id") id: String) : PlanetDto
}