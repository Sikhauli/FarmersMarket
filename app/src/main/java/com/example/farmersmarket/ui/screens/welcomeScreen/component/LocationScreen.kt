package com.example.farmersmarket.ui.screens.welcomeScreen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("MissingPermission")
@Composable
fun LocationScreen(
  onNext: () -> Unit,
) {
  Column(
  ) {
    Button(onClick = onNext) {
      Text("Next")
    }
  }
}









