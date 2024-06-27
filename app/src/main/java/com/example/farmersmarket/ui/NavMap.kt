package com.example.farmersmarket.ui

import MapLocationScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmersmarket.ui.screens.WelcomeScreen
import com.example.farmersmarket.ui.screens.detailsScreen.DetailsMainScreen
import com.example.farmersmarket.ui.screens.homeScreen.HomeMainScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.WelcomeMainScreen

//@Composable
//fun NavigationMap(
//  modifier: Modifier = Modifier,
//  state: MapState,
//  setupClusterManager: (Context, GoogleMap) -> ZoneClusterManager,
//  calculateZoneViewCenter: () -> LatLngBounds,
//  ) {
//  val navController = rememberNavController()
//  NavHost(navController = navController, startDestination = "location",  modifier = modifier) {
//    composable("location") { MapScreen(state, setupClusterManager, calculateZoneViewCenter) }
//    composable("welcome") { WelcomeScreen(navController) }
//    composable("register") { WelcomeMainScreen(navController, state, setupClusterManager, calculateZoneViewCenter) }
//    composable("home") { HomeMainScreen(navController) }
//    composable("details") {
//      DetailsMainScreen(it)
//    }
//  }
//}


@Composable
fun NavigationMap(
  modifier: Modifier = Modifier,
  context: Context
) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "location",  modifier = modifier) {
    composable("location") { MapLocationScreen(context) }
    composable("welcome") { WelcomeScreen(navController) }
    composable("register") { WelcomeMainScreen(navController, context) }
    composable("home") { HomeMainScreen(navController) }
    composable("details") {
      DetailsMainScreen(it)
    }
  }
}