package com.example.farmersmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.farmersmarket.ui.NavigationMap
import com.example.farmersmarket.ui.theme.FarmersMarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      FarmersMarketTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          NavigationMap(modifier = Modifier.padding(innerPadding), context = this)
        }
      }
    }
  }
}
