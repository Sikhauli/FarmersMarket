package com.example.farmersmarket.ui.screens.homeScreen.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.farmersmarket.R

@Composable
fun GreetingsRow() {
  Row(
    modifier = Modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {

    Icon(
      painter = painterResource(id = R.drawable.user),
      contentDescription = "User Icon",
      modifier = Modifier
        .background(Color.Transparent, shape = CircleShape)
        .width(35.dp)
        .height(35.dp)
        .border(2.dp, Color.LightGray, shape = CircleShape)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Column {
      Text(
        text = "Good Morning!",
        style = TextStyle(
          color = MaterialTheme.colorScheme.inverseSurface,
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold
        ),
      )
      Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Icon(
          painter = painterResource(id = R.drawable.location),
          contentDescription = "location Icon",
          modifier = Modifier
            .size(11.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
          text = "Vhuthuhawe",
          style = TextStyle(
            color = MaterialTheme.colorScheme.inverseSurface,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
          )
        )
      }

    }
    Spacer(modifier = Modifier.weight(1f))
    Icon(
      painter = painterResource(id = R.drawable.search),
      contentDescription = "search Icon",
      modifier = Modifier
        .width(20.dp)
        .height(20.dp)
    )
    Spacer(modifier = Modifier.width(10.dp))
    Icon(
      painter = painterResource(id = R.drawable.menu),
      contentDescription = "menu Icon",
      modifier = Modifier
        .width(30.dp)
        .height(30.dp)
    )
  }
}