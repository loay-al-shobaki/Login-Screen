package com.example.loginscreen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreen.R
import com.example.loginscreen.app.data.SignupViewModel
import com.example.loginscreen.app.data.SignupUIEvent
import com.example.loginscreen.components.ButtonComponent
import com.example.loginscreen.components.CheckboxComponent
import com.example.loginscreen.components.ClickbleLoginTextComponent
import com.example.loginscreen.components.DividerTextComponent
import com.example.loginscreen.components.HeadingTextComponent
import com.example.loginscreen.components.MyTextFieldComponent
import com.example.loginscreen.components.NormalTextComponent
import com.example.loginscreen.components.PasswordTextFieldComponent
import com.example.loginscreen.navigation.PostOfficeAppRouter
import com.example.loginscreen.navigation.Screen

@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_Account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.firstname),
                    painter = painterResource(id = R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus =  signupViewModel.registrationUIState.firstNameError

                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.last_name),
                    painter = painterResource(id = R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus =  signupViewModel.registrationUIState.lastNameError
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painter = painterResource(id = R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                    },
                    signupViewModel.registrationUIState.emailError
                )
                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painter = painterResource(id = R.drawable.lock),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    signupViewModel.registrationUIState.passwordError
                )
                CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(value = stringResource(id = R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                DividerTextComponent()

                ClickbleLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })
            }

        }

        if (signupViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }

    }


}

@Preview
@Composable
fun DefaultPreviewSignUpScreen() {
    SignUpScreen()
}