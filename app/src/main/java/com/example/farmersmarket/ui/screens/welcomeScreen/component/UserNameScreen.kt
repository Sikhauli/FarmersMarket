package com.example.farmersmarket.ui.screens.welcomeScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmersmarket.R

@Composable
fun UserNameScreen(onNext: () -> Unit) {

  var username by remember { mutableStateOf("") }

  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier.fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        painter = painterResource(id = R.drawable.healthy_food_pana),
        contentDescription = null,
      )

      Text(
        text = "Create Username",
        color = Color.DarkGray,
        modifier = Modifier.padding(bottom = 24.dp)
      )

      OutlinedTextField(
      value = username,
      onValueChange = { username = it },
      label = { Text("Username") },
      singleLine = true,
      modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(16.dp))

      Button(
        onClick = onNext,
        modifier = Modifier
          .fillMaxWidth()
          .height(50.dp)
          .border(1.dp, MaterialTheme.colorScheme.background, shape = RoundedCornerShape(12.dp))
          .background(Color.LightGray, shape = RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
      ) {
        Text(text = "Continue")
      }
    }
  }
}

