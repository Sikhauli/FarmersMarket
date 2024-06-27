package com.example.farmersmarket.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.isGranted
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@SuppressLint("MissingPermission")
@Composable
fun rememberLocationProviderClient(context: Context): FusedLocationProviderClient {
  val fusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
  val coroutineScope = rememberCoroutineScope()

  return remember {
    fusedLocationProviderClient
  }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermission(
  onPermissionGranted: (Boolean) -> Unit
) {
  val permissionState = rememberPermissionState(android.Manifest.permission.ACCESS_FINE_LOCATION)
  val updatedPermissionGranted = rememberUpdatedState(onPermissionGranted)

  LaunchedEffect(permissionState) {
    if (permissionState.status.isGranted) {
      updatedPermissionGranted.value(true)
    } else {
      permissionState.launchPermissionRequest()
    }
  }

  permissionState.status.isGranted
}



