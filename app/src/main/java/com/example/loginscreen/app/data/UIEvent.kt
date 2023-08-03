package com.example.loginscreen.app.data

sealed class UIEvent {
    data class FirstNameChanged(val firtsName: String) : UIEvent()
    data class LastNameChanged(val lastname: String) : UIEvent()
    data class EmailChanged(val email: String) : UIEvent()
    data class PasswordChanged(val password: String) : UIEvent()

    object RegisterButtonClicked:UIEvent()

}
