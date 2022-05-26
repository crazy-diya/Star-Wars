package com.ktl1.starwars.presentation.planet_list

import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.domain.model.Planets

data class PlanetListState(
    val isLoading: Boolean = false,
    val planetList: Planets? = null,
    val error: String = ""
)
