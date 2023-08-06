package com.example.loginscreen.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginscreen.app.data.home.HomeViewModel
import com.example.loginscreen.navigation.PostOfficeAppRouter
import com.example.loginscreen.navigation.Screen
import com.example.loginscreen.screens.HomeScreen
import com.example.loginscreen.screens.LoginScreen
import com.example.loginscreen.screens.SignUpScreen
import com.example.loginscreen.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp(homeViewModel: HomeViewModel = HomeViewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White,
    ) {

        if (homeViewModel.isUserLogedIn.value == true){
            PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                else -> {}
            }

        }
    }
}


@Preview
@Composable
fun PreviewPostOfficeApp() {
    PostOfficeApp()
}