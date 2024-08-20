package com.example.farmersmarket.ui.screens.welcomeScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.farmersmarket.ui.screens.homeScreen.HomeMainScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterCredentials
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterName
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.HomeMainScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.LocationScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.UserTypeScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.component.CredentialsScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.component.LocationScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.component.UserNameScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.component.UserTypeScreen

sealed class RegisterScreen {
  data object UserTypeScreen : RegisterScreen()
  data object LocationScreen : RegisterScreen()
  data object EnterName : RegisterScreen()
  data object EnterCredentials : RegisterScreen()
  data object HomeMainScreen : RegisterScreen()
}

@Composable
fun WelcomeMainScreen(navController: NavHostController) {
  var currentScreen by remember { mutableStateOf<RegisterScreen>(UserTypeScreen) }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
  ) {
    AnimatedVisibility(
      visible = currentScreen is UserTypeScreen,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      UserTypeScreen(onNext = {
        currentScreen = LocationScreen
      })
    }

    AnimatedVisibility(
      visible = currentScreen is LocationScreen,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      LocationScreen(
        onNext = {
        currentScreen = EnterName
      }
      )
    }

    AnimatedVisibility(
      visible = currentScreen is EnterName,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      UserNameScreen(onNext = {
        currentScreen = EnterCredentials
      })
    }

    AnimatedVisibility(
      visible = currentScreen is EnterCredentials,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      CredentialsScreen(onNext = {
        currentScreen = HomeMainScreen
      })
    }

    AnimatedVisibility(
      visible = currentScreen is HomeMainScreen,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      HomeMainScreen(navController)
    }

  }
}





