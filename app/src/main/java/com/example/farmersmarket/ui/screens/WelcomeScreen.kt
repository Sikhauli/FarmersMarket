package com.example.farmersmarket.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.farmersmarket.R

@Composable
fun WelcomeScreen(navController: NavHostController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(vertical = 10.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Image(
      painter = painterResource(id = R.drawable.welcome_rafiki),
      contentDescription = null,
    )
    Text(
      text = "Hello Friend, Welcome to our market",
      fontSize = 17.sp,
      fontWeight = FontWeight.Bold,
      fontFamily = FontFamily.Serif
    )
    Text(
      text = "Lets make you at home",
      fontSize = 16.sp,
      fontWeight = FontWeight.SemiBold,
      fontFamily = FontFamily.Serif
    )
    Spacer(modifier = Modifier.padding(vertical = 20.dp))
    Button(
      onClick = { navController.navigate("register") },
      modifier = Modifier
        .padding(10.dp)
        .size(300.dp, 60.dp)
        .border(1.dp, MaterialTheme.colorScheme.background, shape = RoundedCornerShape(12.dp))
        .background(Color.LightGray, shape = RoundedCornerShape(12.dp)),
      colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
      Row {
        Text(
          text = "Sign In",
          fontSize = MaterialTheme.typography.bodyMedium.fontSize
        )
      }
    }
    Spacer(modifier = Modifier.padding(bottom = 10.dp))
    Button(
      onClick = { navController.navigate("register") },
      modifier = Modifier
        .padding(10.dp)
        .size(300.dp, 60.dp)
        .border(1.dp, MaterialTheme.colorScheme.background, shape = RoundedCornerShape(12.dp))
        .background(Color.LightGray, shape = RoundedCornerShape(12.dp)),
      colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
      Text(
        text = "Sign Up",
        fontSize = MaterialTheme.typography.bodyMedium.fontSize
      )
    }
    Spacer(modifier = Modifier.padding(vertical = 30.dp))
    Text(
      text = "Welcome to Farmers Marketplace App. By using our app, you agree to our terms ",
      fontSize = 8.sp,
    )
    Text(
      text = "and conditions. If you do not agree, please do not use the app",
      fontSize = 6.sp,
    )
  }
}

