package com.tn.shoestore.ui.welcome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WelcomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WelcomeViewState())
    val uiState: StateFlow<WelcomeViewState> = _uiState.asStateFlow()

    fun onClickDiscovery() {
        _uiState.update {
            it.copy(isOpenIntroduceScreen = true)
        }
    }

    data class WelcomeViewState(
        val isOpenIntroduceScreen: Boolean = false
    )
}