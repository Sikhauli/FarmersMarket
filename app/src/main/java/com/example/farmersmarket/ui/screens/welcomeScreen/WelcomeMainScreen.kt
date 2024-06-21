package com.example.farmersmarket.ui.screens.welcomeScreen

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.BuyerOrSeller
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterCredentials
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.EnterName
import com.example.farmersmarket.ui.screens.welcomeScreen.RegisterScreen.Welcome
import com.example.farmersmarket.ui.screens.welcomeScreen.component.WelcomeScreen

sealed class RegisterScreen {
  data object Welcome : RegisterScreen()
  data object BuyerOrSeller : RegisterScreen()
  data object EnterName : RegisterScreen()
  data object EnterCredentials : RegisterScreen()
}

@Composable
fun WelcomeMainScreen() {
  var currentScreen by remember { mutableStateOf<RegisterScreen>(Welcome) }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
  ) {
    AnimatedVisibility(
      visible = currentScreen is Welcome,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      WelcomeScreen()
    }

    AnimatedVisibility(
      visible = currentScreen is BuyerOrSeller,
      enter = fadeIn(),
      exit = fadeOut()
    ) {
      BuyerOrSellerScreen()
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
        is Welcome -> BuyerOrSeller
        is BuyerOrSeller -> EnterName
        is EnterName -> EnterCredentials
        is EnterCredentials -> Welcome // Or navigate to some other screen
      }
    }) {
      Text(text = "Next")
    }
  }
}

@Composable
fun BuyerOrSellerScreen() {
  Text(text = "Are you a Buyer or Seller?", fontSize = 24.sp)
}

@Composable
fun EnterNameScreen() {
  Text(text = "Enter your Name", fontSize = 24.sp)
}

@Composable
fun EnterCredentialsScreen() {
  Text(text = "Enter your Email and Password", fontSize = 24.sp)
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterMainScreen() {
  WelcomeMainScreen()
}

