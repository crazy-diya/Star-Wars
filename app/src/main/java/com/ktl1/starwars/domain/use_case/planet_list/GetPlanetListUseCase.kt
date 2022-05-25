package com.ktl1.starwars.domain.use_case.planet_list

import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.data.remote.dto.toPlanets
import com.ktl1.starwars.domain.model.Planets
import com.ktl1.starwars.domain.repository.StarWarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetPlanetListUseCase @Inject constructor(
    private val repository: StarWarsRepository
){
    operator fun invoke(): Flow<Resource<Planets>> = flow {
        try {
            emit(Resource.Loading<Planets>())
            val planets = repository.getAllPlanets().toPlanets() /// poddak aul wade
            emit(Resource.Success<Planets>(planets))
        } catch (e: HttpException){
            emit(Resource.Error<Planets>(e.localizedMessage?:"An unexpected error occured!"))
        } catch (e: IOException){
            emit(Resource.Error<Planets>("Couldn't reache server. check your internet connection!"))
        }
    }

}