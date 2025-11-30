package com.example.cuentosfrontend.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuentosfrontend.data.DTO.CreateUserRequest
import com.example.cuentosfrontend.data.DTO.IdOnly
import com.example.cuentosfrontend.data.DTO.Language
import com.example.cuentosfrontend.data.service.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


//UserState define los estados posibles de la pantalla
sealed class UserState {
    object Idle : UserState()//no pasa nada
    object Loading : UserState()//la llamada en curso
    data class Success(val message: String) : UserState()//el user se creo correctamente
    data class Error(val error: String) : UserState()//hubo un error
}


//El ViewModel maneja las llamadas a Retrofit y actualiza el StateFlow.
class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow<UserState>(UserState.Idle)
    val state: StateFlow<UserState> = _state

    fun registerUser(language: Language) {

        val body = CreateUserRequest(
            profile = IdOnly(1L),                // profile "free"
            language = IdOnly(language.id)       // solo mandamos el ID
        )

        viewModelScope.launch {
            try {
                _state.value = UserState.Loading

                val result = ApiClient.userApi.createUser(body)

                _state.value = UserState.Success("Usuario creado con ID: ${result.id}")

            } catch (e: Exception) {
                _state.value = UserState.Error("Error: ${e.message}")
            }
        }
    }
}


