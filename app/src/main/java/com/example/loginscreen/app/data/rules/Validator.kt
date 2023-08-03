package com.example.loginscreen.app.data.rules

object Validator {

    fun validateFirstName(fName: String): ValidateionResult {
        return ValidateionResult(
            (!fName.isNullOrEmpty() && fName.length > 2)
        )
    }

    fun validateLast(lName: String): ValidateionResult {
        return ValidateionResult(
            (!lName.isNullOrEmpty() && lName.length > 2)
        )
    }

    fun validateEmail(email: String): ValidateionResult {
        return ValidateionResult(
            (!email.isNullOrEmpty())
        )
    }

    fun validatePassword(password: String): ValidateionResult {
        return ValidateionResult(
            (!password.isNullOrEmpty() && password.length > 4)
        )
    }

}

data class ValidateionResult(
    val status: Boolean = false
)