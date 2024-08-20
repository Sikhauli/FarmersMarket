package com.example.farmersmarket.ui.screens.homeScreen.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersmarket.data.RecentlyListedCategory

@Composable
fun RecentlyListed() {
  Column() {
    Row(
      modifier = Modifier.padding(vertical = 20.dp),
      verticalAlignment = Alignment.CenterVertically

    ) {
      Text(
        text = "Recently Listed",
        fontFamily = FontFamily.Serif,
        color = MaterialTheme.colorScheme.inverseSurface,
        fontWeight = FontWeight.SemiBold,
      )
      Spacer(modifier = Modifier.weight(1f))
      Text(
        text = "View all",
        fontSize = 12.sp,
        fontFamily = FontFamily.Serif,
        color = Color.Green,
        fontWeight = FontWeight.SemiBold,
      )
    }
    LazyRow()
    {
      itemsIndexed(RecentlyListedCategory) { index, item ->
        Box(
          modifier = Modifier
            .size(180.dp, 200.dp)
            .padding(horizontal = 4.dp)
            .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(6.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(6.dp))
        ) {
          Column {
            Image(
              painter = painterResource(id = item.image),
              contentDescription = null,
              modifier = Modifier
                .size(180.dp, 130.dp)
                .padding(8.dp),
              contentScale = ContentScale.Crop
            )
            Text(
              text = item.productName,
              fontFamily = FontFamily.Default,
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
            )
            Text(
              text = "R${item.price}/ ${item.size}kg",
              fontFamily = FontFamily.Default,
              fontSize = 10.sp,
              fontWeight = FontWeight.Normal,
              modifier = Modifier.padding(horizontal = 8.dp),
            )
          }
          IconButton(
            onClick = {
              // Handle Add button click event
            },
            modifier = Modifier
              .align(Alignment.BottomEnd)
              .background(Color.Green, shape = RoundedCornerShape(10.dp))
              .border(1.dp, Color.Transparent, shape = RoundedCornerShape(10.dp))
          ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
          }
        }
      }
    }
  }
}