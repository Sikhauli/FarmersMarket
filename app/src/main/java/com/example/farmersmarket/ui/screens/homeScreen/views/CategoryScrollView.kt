package com.example.farmersmarket.ui.screens.homeScreen.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersmarket.data.ShoppingByCategory

@Composable
fun CategoryScrollView() {
  Column() {
    Row(
      modifier = Modifier.padding(vertical = 20.dp),
      verticalAlignment = Alignment.CenterVertically

    ) {
      Text(
        text = "Shop By Categories",
        fontFamily = FontFamily.Serif,
        color = MaterialTheme.colorScheme.inverseSurface,
        fontWeight = FontWeight.SemiBold,
      )
    }

    Row(
      modifier = Modifier
        .horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      verticalAlignment = Alignment.CenterVertically,
    )
    {
      ShoppingByCategory.forEach { category ->
        Row(
          modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseSurface , shape = RoundedCornerShape(6.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(6.dp)),
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Box(
            modifier = Modifier.size(30.dp),
            contentAlignment = Alignment.Center
          ) {
            Image(
              painter = painterResource(id = category.icon),
              contentDescription = null,
            )
          }
          Text(
            text = category.product,
            modifier = Modifier
              .padding(horizontal = 0.dp, vertical = 8.dp)
              .padding(8.dp)
              .width(55.dp),
            style = TextStyle(
              color = MaterialTheme.colorScheme.inverseSurface,
              fontSize = 16.sp,
              fontWeight = FontWeight.Normal
            ),
            textAlign = TextAlign.Center
          )
        }
      }
    }
  }
}