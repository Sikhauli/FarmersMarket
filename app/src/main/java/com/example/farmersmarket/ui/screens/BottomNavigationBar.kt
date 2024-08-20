package com.example.farmersmarket.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import bottomNavItems

@Composable
fun BottomNavigationBar(navController: NavHostController) {
  NavigationBar {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    bottomNavItems.forEach { item ->
      NavigationBarItem(
        icon = {
          Box(
            modifier = Modifier
              .size(34.dp)
              .background(
                color = if (currentRoute == item.route) Color.Green else Color.Transparent,
                shape = CircleShape
              )
              .padding(2.dp)
          ) {
            Icon(
              imageVector = item.icon,
              contentDescription = item.label,
              tint = if (currentRoute == item.route) Color.Green else Color.Gray
            )
          }
        },
        label = {
          Text(
            text = item.label,
            color = if (currentRoute == item.route) MaterialTheme.colorScheme.secondary else Color.Gray
          )
        },
        selected = currentRoute == item.route,
        onClick = {
          navController.navigate(item.route) {
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
          }
        }
      )
    }
  }
}


@Composable
fun BottomNavigationBarWithFab(navController: NavHostController) {
  Box {
    BottomNavigationBar(navController)
    FloatingActionButton(
      onClick = { /* FAB action */ },
      modifier = Modifier
        .align(Alignment.TopCenter)
        .offset(y = (-28).dp),
      containerColor = MaterialTheme.colorScheme.primary
    ) {
      Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Green )
    }
  }
}