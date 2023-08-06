package com.example.loginscreen.app.data.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginscreen.app.data.rules.Validator
import com.example.loginscreen.navigation.PostOfficeAppRouter
import com.example.loginscreen.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName

    var loginUIState by mutableStateOf(LoginUIState())
    var allValidationsPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState = loginUIState.copy(
                    emai = event.email
                )

                validateLoginUIDataWithRules()
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState = loginUIState.copy(
                    password = event.password
                )
                validateLoginUIDataWithRules()
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
                validateLoginUIDataWithRules()
            }

            else -> {}
        }

    }


    private fun validateLoginUIDataWithRules() {

        val emailResult = Validator.validateEmail(
            email = loginUIState.emai
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.password
        )

        Log.d(TAG, "validateDataWithRules: ")
        Log.d(TAG, "emailResult $emailResult")
        Log.d(TAG, "passwordResult: $passwordResult")

        loginUIState = loginUIState.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )

        allValidationsPassed.value =
            emailResult.status && passwordResult.status
    }

    private fun login() {
        loginInProgress.value = true
        val email = loginUIState.emai
        val password = loginUIState.password
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "login: inside login success")
                Log.d(TAG, "login: ${it.isSuccessful}")
                if (it.isSuccessful) {
                    loginInProgress.value = false
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "login: Login Failure")
                loginInProgress.value = false
            }
    }


    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "logout: inside sign outsuccess")
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d(TAG, "logout: Inside sign is not complete")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }


}