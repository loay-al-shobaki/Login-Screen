package com.example.loginscreen.app.data

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

class SignupViewModel : ViewModel() {
    private val TAG = SignupViewModel::class.java.simpleName

    var registrationUIState by mutableStateOf(RegistrationUIState())
    var allValidationsPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        validateDataWithRules()
        when (event) {
            is SignupUIEvent.FirstNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    firstName = event.firtsName
                )
                printState()
                validateDataWithRules()
            }

            is SignupUIEvent.LastNameChanged -> {
                registrationUIState = registrationUIState.copy(
                    lastName = event.lastname
                )
                printState()
                validateDataWithRules()
            }

            is SignupUIEvent.EmailChanged -> {
                registrationUIState = registrationUIState.copy(
                    emai = event.email
                )
                printState()
                validateDataWithRules()
            }

            is SignupUIEvent.PasswordChanged -> {
                registrationUIState = registrationUIState.copy(
                    password = event.password
                )
                printState()
                validateDataWithRules()
            }

            is SignupUIEvent.RegisterButtonClicked -> {
                sginUp()
                validateDataWithRules()
            }

            is SignupUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState = registrationUIState.copy(
                    privacvPolicyAccepted = event.status
                )
            }

            else -> {}
        }

    }

    private fun sginUp() {
        Log.d(TAG, "sginUp: indide_signUp")
        printState()
        createUserInFirebase(
            email = registrationUIState.emai,
            password = registrationUIState.password
        )

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
        val privactPolicyResult = Validator.validatePrivacyPolicyAccepted(
            statusValue = registrationUIState.privacvPolicyAccepted
        )
        Log.d(TAG, "validateDataWithRules: ")
        Log.d(TAG, "fNameResult: $fNameResult")
        Log.d(TAG, "lNameResult: $lNameResult")
        Log.d(TAG, "emailResult: $emailResult")
        Log.d(TAG, "passwordResult: $passwordResult")
        Log.d(TAG, "privactPolicyResult: $privactPolicyResult")
        registrationUIState = registrationUIState.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacvPolicyAccepted = privactPolicyResult.status
        )

        allValidationsPassed.value = fNameResult.status && lNameResult.status &&
                emailResult.status && passwordResult.status && privactPolicyResult.status
    }

    private fun printState() {
        Log.d(TAG, "printState: Inside_printState")
        Log.d(TAG, registrationUIState.toString())
    }

    private fun createUserInFirebase(email: String, password: String) {
        signUpInProgress.value = true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email.trim(), password)
            .addOnCompleteListener {
                Log.d(TAG, "createUserInFirbase: indside_onCompleteListener")
                Log.d(TAG, "createUserInFirbase: isSuccessful = ${it.isSuccessful}")
                signUpInProgress.value = true

                if (it.isSuccessful) {
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "createUserInFirbase: inside_onFailuerListener")
                Log.d(TAG, "createUserInFirbase: ${it.message}")
                Log.d(TAG, "createUserInFirbase: ${it.localizedMessage}")
            }
    }

    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "logout: inside sign outsuccess")
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            } else{
                Log.d(TAG, "logout: Inside sign is not complete")

            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }


}