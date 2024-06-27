package com.example.farmersmarket.ui.screens.welcomeScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.farmersmarket.R

@Composable
fun UserTypeScreen(navController: NavHostController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(vertical = 10.dp, horizontal = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Spacer(modifier = Modifier.height(100.dp))
    Text(
      text = "Let's Get Started On",
      fontSize = 28.sp,
      fontWeight = FontWeight.Bold,
      fontFamily = FontFamily.Serif
    )
    Text(
      text = "Your Journey",
      fontSize = 26.sp,
      fontWeight = FontWeight.Bold,
      fontFamily = FontFamily.Serif
    )
    Spacer(modifier = Modifier.height(30.dp))
    Text(
      text = "Tell us who you are, so we can tailor your",
      fontSize = 14.sp,
      fontFamily = FontFamily.Serif
    )
    Text(
      text = "Farmers Market experience",
      fontSize = 13.sp,
      fontFamily = FontFamily.Serif
    )
    Spacer(modifier = Modifier.height(50.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxHeight()
          .width(170.dp)
          .border(1.dp, Color.LightGray, shape = RoundedCornerShape(12.dp))
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Transparent, shape = RoundedCornerShape(50)),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Image(
            painter = painterResource(id = R.drawable.farmer_bro),
            contentDescription = "Farmer",
            modifier = Modifier
              .size(100.dp)
              .clip(RoundedCornerShape(50))
          )
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "I'm a Farmer",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
          )
          Spacer(modifier = Modifier.height(5.dp))
          Text(
            text = "For those who grow ",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif
          )
          Text(
            text = "the goodness",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif
          )
        }
      }
      Spacer(modifier = Modifier.width(5.dp))
      Box(
        modifier = Modifier
          .fillMaxHeight()
          .width(200.dp)
          .border(1.dp, Color.LightGray, shape = RoundedCornerShape(12.dp))
          .clickable {
            navController.navigate("details")
          }
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Transparent, shape = RoundedCornerShape(50)),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Image(
            painter = painterResource(id = R.drawable.foody),
            contentDescription = "Foodie",
            modifier = Modifier
              .size(100.dp)
              .clip(RoundedCornerShape(50))
          )
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "I'm a Foodie",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
          )
          Spacer(modifier = Modifier.height(5.dp))
          Text(
            text = "For those who savor ",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif
          )
          Text(
            text = "the goodness",
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif
          )
        }
      }
    }
  }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewWelcomeScreen() {
//  UserTypeScreen(navController)
//}

