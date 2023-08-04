package com.example.loginscreen.app.data

data class RegistrationUIState(
    var firstName: String = "",
    var lastName: String = "",
    var emai: String = "",
    var password: String = "",

    var firstNameError: Boolean = false,
    var lastNameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var privacvPolicyAccepted:Boolean =false
)