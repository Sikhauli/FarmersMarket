package com.example.farmersmarket.ui.screens.welcomeScreen

import MapLocationScreen
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterCredentials
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterName
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.HomeScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.LocationScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.UserTypeScreen
import com.example.farmersmarket.ui.screens.welcomeScreen.component.UserTypeScreen


sealed class RegisterScreen {
  data object UserTypeScreen : RegisterScreen()
  data object LocationScreen : RegisterScreen()
  data object EnterName : RegisterScreen()
  data object EnterCredentials : RegisterScreen()
  data object HomeScreen : RegisterScreen()
}

@Composable
fun WelcomeMainScreen(navController: NavHostController, context: Context) {
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
      UserTypeScreen(navController)
    }

    AnimatedVisibility(
      visible = currentScreen is LocationScreen,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      MapLocationScreen(context)
    }

    AnimatedVisibility(
      visible = currentScreen is EnterName,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      EnterNameScreen()
    }

    AnimatedVisibility(
      visible = currentScreen is EnterCredentials,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      EnterCredentialsScreen()
    }

    Spacer(modifier = Modifier.height(20.dp))

    Button(onClick = {
      currentScreen = when (currentScreen) {
        is UserTypeScreen -> LocationScreen
        is LocationScreen -> EnterName
        is EnterName -> EnterCredentials
        is EnterCredentials -> HomeScreen
        HomeScreen -> TODO()
      }
    }) {
      Text(text = "Next")
    }
  }
}

@Composable
fun EnterNameScreen() {
  Text(text = "Enter your Name", fontSize = 24.sp)
}

@Composable
fun EnterCredentialsScreen() {
  Text(text = "Enter your Email and Password", fontSize = 24.sp)
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewRegisterMainScreen() {
//  WelcomeMainScreen(navController)
//}

