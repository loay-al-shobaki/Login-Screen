package com.example.loginscreen.app.data.rules

data class LoginUIState(
    var emai: String = "",
    var password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false,

)