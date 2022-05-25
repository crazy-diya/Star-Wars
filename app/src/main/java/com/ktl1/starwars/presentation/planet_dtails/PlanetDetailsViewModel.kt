package com.ktl1.starwars.presentation.planet_dtails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktl1.starwars.common.Constants
import com.ktl1.starwars.common.Resource
import com.ktl1.starwars.domain.use_case.planet_details.GetPlanetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlanetDetailsViewModel @Inject constructor(
    private val getPlanetDetailsUseCase: GetPlanetDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PlanetDetailsState())
    val state: State<PlanetDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ID)?.let { id ->
            getPlanet(id)
        }
    }

    private fun getPlanet(id:String) {
        getPlanetDetailsUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlanetDetailsState(planetDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        PlanetDetailsState(error = result.message ?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = PlanetDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}