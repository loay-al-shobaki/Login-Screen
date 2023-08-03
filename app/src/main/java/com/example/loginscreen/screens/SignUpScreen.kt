package com.example.loginscreen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreen.R
import com.example.loginscreen.app.data.LoginViewModel
import com.example.loginscreen.app.data.UIEvent
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
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {
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
                    loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
                },
                errorStatus =  loginViewModel.registrationUIState.firstNameError

            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painter = painterResource(id = R.drawable.profile),
                onTextChanged = {
                    loginViewModel.onEvent(UIEvent.LastNameChanged(it))
                },
                errorStatus =  loginViewModel.registrationUIState.lastNameError
            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painter = painterResource(id = R.drawable.message),
                onTextChanged = {
                    loginViewModel.onEvent(UIEvent.EmailChanged(it))
                },
                loginViewModel.registrationUIState.emailError
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painter = painterResource(id = R.drawable.lock),
                onTextChanged = {
                    loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                },
                loginViewModel.registrationUIState.passwordError
            )
            CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register),
                onButtonClicked = {
                    loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
                }
            )

            DividerTextComponent()

            ClickbleLoginTextComponent(tryingToLogin = true, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }

    }
}

@Preview
@Composable
fun DefaultPreviewSignUpScreen() {
    SignUpScreen()
}