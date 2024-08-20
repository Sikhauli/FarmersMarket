package com.example.farmersmarket.data

import com.example.farmersmarket.R

data class RecentlyListed(
  val productName: String,
  val image: Int,
  val price: Double,
  val size: Int
)

val RecentlyListedCategory = listOf(
  RecentlyListed("Carrot", R.drawable.carrots, 89.99, 1),
  RecentlyListed("Cabbage", R.drawable.cabbage, 39.99, 1),
  RecentlyListed("Pepper", R.drawable.pepper, 59.99, 1),
  RecentlyListed("Tomatoes", R.drawable.tomatoes, 99.99, 1),
  RecentlyListed("Tomatoes", R.drawable.tomatoes, 19.99, 1),
  RecentlyListed("Carrot", R.drawable.carrots, 89.99, 1),
  RecentlyListed("Cabbage", R.drawable.cabbage, 39.99, 1),
  RecentlyListed("Pepper", R.drawable.pepper, 59.99, 1),
  RecentlyListed("Tomatoes", R.drawable.tomatoes, 99.99, 1),
  RecentlyListed("Tomatoes", R.drawable.tomatoes, 19.99, 1)
)
