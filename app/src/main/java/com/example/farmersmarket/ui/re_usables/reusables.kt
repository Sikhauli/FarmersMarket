package com.example.farmersmarket.ui.re_usables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LocalResourceImageComponent(@DrawableRes resId: Int) {
  // There are multiple methods available to load an image resource in Compose. However, it would
  // be advisable to use the painterResource method as it loads an image resource asynchronously
  val image = painterResource(resId)

  // Image is a pre-defined composable that lays out and draws a given [ImageBitmap].

  // You can think of Modifiers as implementations of the decorators pattern that are
  // used to modify the composable that its applied to. In this example, we configure the
  // Image composable to have a height of 200 dp.
  Image(
    painter = image,
    contentDescription = null,
//    modifier = Modifier.fillMaxWidth()
  )
}

@Composable
fun CustomButton(onClick: () -> Unit) {
  Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(Color.Blue),

  ) {
    Text(text = "Custom Button", color = Color.White)
  }
}