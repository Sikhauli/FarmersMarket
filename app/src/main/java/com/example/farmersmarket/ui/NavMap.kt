package com.example.farmersmarket.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmersmarket.ui.screens.detailsScreen.DetailsMainScreen
import com.example.farmersmarket.ui.screens.homeScreen.HomeMainScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.WelcomeMainScreen

@Composable
fun NavigationMap(modifier: Modifier = Modifier) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "welcome",  modifier = modifier) {
    composable("welcome") { WelcomeMainScreen() }
    composable("home") { HomeMainScreen(navController) }
    composable("details") {
      DetailsMainScreen(it)
    }
  }
}
