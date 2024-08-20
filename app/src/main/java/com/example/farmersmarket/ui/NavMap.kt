package com.example.farmersmarket.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.farmersmarket.ui.screens.BottomNavigationBarWithFab
import com.example.farmersmarket.ui.screens.WelcomeScreen
import com.example.farmersmarket.ui.screens.detailsScreen.DetailsMainScreen
import com.example.farmersmarket.ui.screens.homeScreen.HomeMainScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.WelcomeMainScreen

@Composable
fun NavigationMap() {
  val navController = rememberNavController()
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route

  Scaffold(
    bottomBar = {
      if (currentRoute == "home") {
        BottomNavigationBarWithFab(navController)
      }
    }
  ) { innerPadding ->
    NavHost(
      navController = navController,
      startDestination = "home",
      modifier = Modifier.padding(innerPadding)
    ) {
      composable("welcome") { WelcomeScreen(navController) }
      composable("register") { WelcomeMainScreen(navController) }
      composable("home") { HomeMainScreen(navController) }
      composable("details") { DetailsMainScreen(it) }
    }
  }
}



