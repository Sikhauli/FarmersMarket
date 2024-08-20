package com.example.farmersmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.farmersmarket.ui.NavigationMap
import com.example.farmersmarket.ui.screens.homeScreen.HomeMainScreen
import com.example.farmersmarket.ui.theme.FarmersMarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      FarmersMarketTheme {
        NavigationMap()
      }
    }
  }
}
