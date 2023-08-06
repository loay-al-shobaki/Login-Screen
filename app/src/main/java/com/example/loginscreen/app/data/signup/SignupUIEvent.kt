package com.example.loginscreen.app.data.signup

sealed class SignupUIEvent {
    data class FirstNameChanged(val firtsName: String) : SignupUIEvent()
    data class LastNameChanged(val lastname: String) : SignupUIEvent()
    data class EmailChanged(val email: String) : SignupUIEvent()
    data class PasswordChanged(val password: String) : SignupUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean): SignupUIEvent()
    object RegisterButtonClicked: SignupUIEvent()

}
