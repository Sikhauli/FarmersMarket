package com.example.farmersmarket.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.farmersmarket.ui.re_usables.DisplayItemGrid
import com.example.farmersmarket.ui.screens.homeScreen.views.BestFarmersView
import com.example.farmersmarket.ui.screens.homeScreen.views.CategoryScrollView
import com.example.farmersmarket.ui.screens.homeScreen.views.GreetingsRow
import com.example.farmersmarket.ui.screens.homeScreen.views.RecentlyListed

@Composable
fun HomeMainScreen(navController: NavHostController) {
  LazyColumn(
    modifier = Modifier.padding(10.dp)
  ) {
    item {
      GreetingsRow()
    }
    item {
      CategoryScrollView()
    }
    item {
      RecentlyListed()
    }
    item {
      BestFarmersView()
    }
    item {
      DisplayItemGrid()
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewRecentlyListed() {
  RecentlyListed()
}
