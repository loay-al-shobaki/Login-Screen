package com.example.loginscreen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreen.app.data.SignupViewModel
import com.example.loginscreen.components.ButtonComponent
import com.example.loginscreen.components.HeadingTextComponent

@Composable
fun HomeScreen(signupViewModel: SignupViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Home")
            ButtonComponent(
                value = "loguot", onButtonClicked = {
                    signupViewModel.logout()
                },
                isEnabled = true
            )
        }
    }
}

@Preview
@Composable
fun HomwScreenPreview() {
    HomeScreen()
}