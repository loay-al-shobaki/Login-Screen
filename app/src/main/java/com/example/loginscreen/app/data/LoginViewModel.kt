package com.example.loginscreen.app.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginscreen.app.data.rules.Validator

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
     var registrationUIState by mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent) {
        validateDataWithRules()
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    firstName = event.firtsName
                )
                printState()
                validateDataWithRules()
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    lastName = event.lastname
                )
                printState()
                validateDataWithRules()
            }

            is UIEvent.EmailChanged -> {
                registrationUIState = registrationUIState.copy(
                    emai = event.email
                )
                printState()
                validateDataWithRules()
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState = registrationUIState.copy(
                    password = event.password
                )
                printState()
                validateDataWithRules()
            }

            is UIEvent.RegisterButtonClicked -> {
                sginUp()
            }

            else -> {}
        }
    }

    private fun sginUp() {
        Log.d(TAG, "sginUp: indide_signUp")
        printState()

        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.firstName
        )
        val lNameResult = Validator.validateLast(
            lName = registrationUIState.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.emai
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.password
        )
        Log.d(TAG, "validateDataWithRules: ")
        Log.d(TAG, "fNameResult: $fNameResult")
        Log.d(TAG, "lNameResult: $lNameResult")
        Log.d(TAG, "emailResult: $emailResult")
        Log.d(TAG, "passwordResult: $passwordResult")

        registrationUIState=registrationUIState.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

    }

    private fun printState() {
        Log.d(TAG, "printState: Inside_printState")
        Log.d(TAG, registrationUIState.toString())
    }
}