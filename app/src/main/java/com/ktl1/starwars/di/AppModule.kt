package com.ktl1.starwars.di

import com.ktl1.starwars.common.Constants
import com.ktl1.starwars.data.remote.StarWarsApi
import com.ktl1.starwars.data.repository.StarWarsRepositoryImpl
import com.ktl1.starwars.domain.repository.StarWarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStarWarApi(): StarWarsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsApi::class.java)
    }

    @Provides
    @Singleton
    fun  provideStarWarsRepository(api: StarWarsApi): StarWarsRepository {
        return StarWarsRepositoryImpl(api)
    }
}