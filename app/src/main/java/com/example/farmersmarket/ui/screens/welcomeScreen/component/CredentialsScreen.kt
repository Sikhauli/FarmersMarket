package com.example.farmersmarket.ui.screens.welcomeScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.farmersmarket.R

@Composable
fun CredentialsScreen(onNext: () -> Unit) {
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
        painter = painterResource(id = R.drawable.sign_in_pana),
        contentDescription = null,
      )
      Text(
        text = "Create Credentials",
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(bottom = 24.dp)
      )

      // State to hold the values
      var email by remember { mutableStateOf("") }
      var password by remember { mutableStateOf("") }
      var passwordVisible by remember { mutableStateOf(false) }

      OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(16.dp))

      OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        trailingIcon = {
          val image = if (passwordVisible)
            Icons.Filled.Close
          else Icons.Filled.Info

          IconButton(onClick = {
            passwordVisible = !passwordVisible
          }) {
            Icon(imageVector = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
          }
        },
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
