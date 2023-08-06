package com.example.loginscreen.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreen.app.data.NavigationItem
import com.example.loginscreen.app.data.home.HomeViewModel
import com.example.loginscreen.components.Drawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    homeViewModel.getUserData()

    val navigationItemsList = listOf<NavigationItem>(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            description = "Home Screen",
            itemId = "homwScreen"
        ), NavigationItem(
            title = "Settings",
            icon = Icons.Default.Settings,
            description = "Setting Screen",
            itemId = "settingScreen"
        ), NavigationItem(
            title = "Favorite",
            icon = Icons.Default.Favorite,
            description = "Favorite Screen",
            itemId = "favoriteScreen"
        )
    )

 Drawer (homeViewModel.emailId.value,navigationItemsList){
     homeViewModel.logout()
 }

    }




@Preview
@Composable
fun HomwScreenPreview() {
    HomeScreen()
}