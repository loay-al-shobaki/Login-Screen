package com.example.loginscreen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.loginscreen.R
import com.example.loginscreen.components.ButtonComponent
import com.example.loginscreen.components.ClickbleLoginTextComponent
import com.example.loginscreen.components.DividerTextComponent
import com.example.loginscreen.components.HeadingTextComponent
import com.example.loginscreen.components.MyTextFieldComponent
import com.example.loginscreen.components.NormalTextComponent
import com.example.loginscreen.components.PasswordTextFieldComponent
import com.example.loginscreen.components.UnderLinedTextComponent
import com.example.loginscreen.navigation.PostOfficeAppRouter
import com.example.loginscreen.navigation.Screen
import com.example.loginscreen.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.wlecome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painter = painterResource(id = R.drawable.message)
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painter = painterResource(id = R.drawable.lock)
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnderLinedTextComponent(stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

         ClickbleLoginTextComponent( tryingToLogin = false ,onTextSelected = {
             PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
         })
        }
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

//git checkout -b sachin/architecture
@Preview
@Composable
fun LoginScreePreview() {
    LoginScreen()
}