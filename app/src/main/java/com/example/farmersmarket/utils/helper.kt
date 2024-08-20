import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

val bottomNavItems = listOf(
  BottomNavItem("Home", Icons.Default.Home, "Home"),
  BottomNavItem("Explore", Icons.Default.Search, "Explore"),
  BottomNavItem("Add", Icons.Default.ArrowDropDown, "Add"),
  BottomNavItem("Farmers", Icons.Default.Person, "Farmers"),
  BottomNavItem("Cart", Icons.Default.ShoppingCart, "Cart"),
  )


