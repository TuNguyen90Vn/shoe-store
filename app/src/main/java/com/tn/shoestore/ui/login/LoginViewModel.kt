package com.tn.shoestore.ui.login

import androidx.lifecycle.ViewModel
import com.tn.shoestore.utils.isValidEmailAddress
import com.tn.shoestore.utils.isValidPassword
import com.tn.shoestore.utils.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginViewState())
    val uiState: StateFlow<LoginViewState> = _uiState.asStateFlow()

    val emailInput = MutableStateFlow("")
    val passwordInput = MutableStateFlow("")

    fun doLogin() {
        launch {
            _uiState.update {
                it.copy(isShowLoading = true)
            }
            delay(1000L)
            _uiState.update {
                it.copy(
                    isShowLoading = false,
                    isLoggedIn = isValidEmailAddress(emailInput.value) && isValidPassword(password = passwordInput.value)
                )
            }
        }
    }

    data class LoginViewState(
        val isLoggedIn: Boolean = false,
        val isShowLoading: Boolean = false
    )
}