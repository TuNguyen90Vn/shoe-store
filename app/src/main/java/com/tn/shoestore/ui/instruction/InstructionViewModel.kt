package com.tn.shoestore.ui.instruction

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InstructionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InstructionViewState())
    val uiState: StateFlow<InstructionViewState> = _uiState.asStateFlow()

    fun openShoeStore() {
        _uiState.update { it.copy(isOpenShoeStore = true) }
    }

    data class InstructionViewState(
        val isOpenShoeStore: Boolean = false
    )
}