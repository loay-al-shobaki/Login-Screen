package com.example.loginscreen.app.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
    private var registrationUIState by mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    firstName = event.firtsName
                )
                printState()
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    lastName = event.lastname
                )
                printState()
            }

            is UIEvent.EmailChanged -> {
                registrationUIState = registrationUIState.copy(
                    emai = event.email
                )
                printState()
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState = registrationUIState.copy(
                    password = event.password
                )
                printState()
            }
        }
    }

    private fun printState(){
        Log.d(TAG, "printState: Inside_printState")
        Log.d(TAG, registrationUIState.toString())
    }
}