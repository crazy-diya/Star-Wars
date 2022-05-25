package com.ktl1.starwars.presentation.planet_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.domain.use_case.planet_list.GetPlanetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(
    private val getPlanetListUseCase: GetPlanetListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PlanetListState())
    val state: State<PlanetListState> = _state

    init {
        getPlanets()
    }

    private fun getPlanets() {
        getPlanetListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlanetListState(planetList = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        PlanetListState(error = result.message ?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = PlanetListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}