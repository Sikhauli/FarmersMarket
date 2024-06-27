import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.farmersmarket.utils.LocationPermission
import com.example.farmersmarket.utils.mapUtils.GoogleMapManager
import com.example.farmersmarket.utils.mapUtils.MapManager
import com.example.farmersmarket.utils.mapUtils.OSMMapManager
import com.example.farmersmarket.utils.rememberLocationProviderClient
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

@Composable
fun MapLocationScreen(context: Context) {
  val fusedLocationProviderClient = rememberLocationProviderClient(context)
  val mapManager: MapManager = if (isGooglePlayServicesAvailable(context)) {
    GoogleMapManager(context)
  } else {
    OSMMapManager(context)
  }
  val coroutineScope = rememberCoroutineScope()
  val locationPermissionGranted = remember { mutableStateOf(false) }

  // Request location permissions
  LocationPermission {
    locationPermissionGranted.value = it
  }

  // Ensure location updates are requested only when permissions are granted
  LaunchedEffect(locationPermissionGranted.value) {
    if (locationPermissionGranted.value) {
      // Check permissions explicitly
      if (ContextCompat.checkSelfPermission(context, permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
        ContextCompat.checkSelfPermission(context, permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
      ) {

        // Create location request
        val locationRequest = LocationRequest.create().apply {
          priority = LocationRequest.PRIORITY_HIGH_ACCURACY
          interval = 10000
          fastestInterval = 5000
        }

        try {
          // Request location updates
          fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
              override fun onLocationResult(locationResult: LocationResult) {
                val location = locationResult.lastLocation ?: return
                mapManager.updateLocation(location)
              }
            },
            Looper.getMainLooper()
          )
        } catch (e: SecurityException) {
          // Handle SecurityException if permissions are not granted
          // This should ideally not be reached if permissions are checked properly
          e.printStackTrace()
        }
      }
    }
  }

  // Display the map using AndroidView
  AndroidView(factory = {
    mapManager.initialize(context)
  })
}

fun isGooglePlayServicesAvailable(context: Context): Boolean {
  val googleApiAvailability = GoogleApiAvailability.getInstance()
  val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)
  return resultCode == ConnectionResult.SUCCESS
}


