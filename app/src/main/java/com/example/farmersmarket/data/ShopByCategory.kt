package com.example.farmersmarket.data

import com.example.farmersmarket.R

data class ShopByCategory(
  val product: String,
  val icon: Int,
)


val ShoppingByCategory = listOf(
  ShopByCategory("Veggie", R.drawable.carrot),
  ShopByCategory("Fruits",  R.drawable.fruits),
  ShopByCategory("Dairy",  R.drawable.cheese),
  ShopByCategory("Meat",  R.drawable.meat),
)