package com.example.farmersmarket.ui.re_usables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersmarket.data.RecentlyListed
import com.example.farmersmarket.data.RecentlyListedCategory


@Composable
fun DisplayItemGrid() {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .height(500.dp)
  ) {
    itemsIndexed(RecentlyListedCategory) { index, item ->
      ItemCard(item)
    }
  }
}

@Composable
fun ItemCard(item: RecentlyListed) {
  Card(
    modifier = Modifier
      .size(180.dp, 250.dp)
      .padding(4.dp),
    shape = RoundedCornerShape(6.dp),
    elevation = CardDefaults.cardElevation(4.dp)
  ) {
    Column(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .border(1.dp, Color.Gray, shape = RoundedCornerShape(6.dp))
    ) {
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
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
      )
      Text(
        text = "R${item.price}/ ${item.size}kg",
        fontFamily = FontFamily.Default,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(horizontal = 8.dp)
      )
      IconButton(
        onClick = {},
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Green, shape = RoundedCornerShape(0.dp))
      ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
      }
    }
  }
}
