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
        val emailPattern = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return ValidateionResult(
            (!email.isNullOrEmpty() && email.matches(emailPattern))
        )
    }

    fun validatePassword(password: String): ValidateionResult {
        return ValidateionResult(
            (!password.isNullOrEmpty() && password.length > 5)
        )
    }

    fun validatePrivacyPolicyAccepted(statusValue:Boolean):ValidateionResult{
        return ValidateionResult(
            statusValue
        )
    }

}

data class ValidateionResult(
    val status: Boolean = false
)