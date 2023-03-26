package com.tn.shoestore.ui.shoes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.tn.shoestore.models.FakeData
import com.tn.shoestore.models.Shoe
import com.tn.shoestore.utils.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class SaveState {
    SAVE,
    CANCEL,
    NONE
}

class ShoeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ShoeListViewState())
    val uiState: StateFlow<ShoeListViewState> = _uiState.asStateFlow()

    init {
        loadFakeData()
    }

    private fun loadFakeData() {
        launch {
            _uiState.update { it.copy(isShowLoading = true) }
            delay(1000)
            _uiState.update {
                it.copy(
                    isShowLoading = false,
                    listShoes = FakeData.createFakeData()
                )
            }
        }
    }

    fun addNewShoe() {
        _uiState.update {
            it.copy(isOpenShoeDetail = true)
        }
    }

    fun resetState() {
        _uiState.update {
            it.copy(
                isOpenShoeDetail = false,
                saveState = SaveState.NONE
            )
        }
    }

    fun onSaveShoe(name: String, size: String, company: String, description: String) {
        val shoe = Shoe(
            name,
            size.toDoubleOrNull() ?: 0.0,
            company,
            description
        )

        _uiState.update {
            it.copy(
                listShoes = it.listShoes.apply {
                    this.add(shoe)
                },
                saveState = SaveState.SAVE
            )
        }
    }

    fun onCancel() {
        _uiState.update {
            it.copy(
                saveState = SaveState.CANCEL
            )
        }
    }

    data class ShoeListViewState(
        val isOpenShoeDetail: Boolean = false,
        val isShowLoading: Boolean = false,
        val listShoes: MutableList<Shoe> = mutableListOf(),
        val saveState: SaveState = SaveState.NONE
    )
}