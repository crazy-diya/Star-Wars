package com.ktl1.starwars.domain.use_case.planet_details

import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.data.remote.dto.toPlanet
import com.ktl1.starwars.domain.model.Planet
import com.ktl1.starwars.domain.repository.StarWarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlanetDetailUseCase @Inject constructor(
    private val repository: StarWarsRepository
) {
    operator fun invoke(id: String): Flow<Resource<Planet>> = flow {
        try {
            emit(Resource.Loading<Planet>())
            val planet = repository.getPlanetById(id).toPlanet() /// poddak aul wade
            emit(Resource.Success<Planet>(planet))
        } catch (e: HttpException){
            emit(Resource.Error<Planet>(e.localizedMessage?:"An unexpected error occured!"))
        } catch (e: IOException){
            emit(Resource.Error<Planet>("Couldn't reache server. check your internet connection!"))
        }
    }
}