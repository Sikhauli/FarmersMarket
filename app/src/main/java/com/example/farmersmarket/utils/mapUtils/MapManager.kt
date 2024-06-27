package com.example.farmersmarket.utils.mapUtils

import android.content.Context
import android.location.Location
import android.widget.FrameLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView as OSMMapView
import org.osmdroid.views.overlay.Marker


import org.osmdroid.views.overlay.Polygon
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

interface MapManager {
  fun initialize(context: Context): FrameLayout
  fun updateLocation(location: Location)
}


class GoogleMapManager(private val context: Context) : MapManager, OnMapReadyCallback {
  private lateinit var mapView: MapView
  private lateinit var googleMap: GoogleMap

  override fun initialize(context: Context): FrameLayout {
    mapView = MapView(context)
    mapView.onCreate(null)
    mapView.getMapAsync(this)
    return mapView
  }

  override fun onMapReady(map: GoogleMap) {
    googleMap = map
  }

  override fun updateLocation(location: Location) {
    if (this::googleMap.isInitialized) {
      val latLng = LatLng(location.latitude, location.longitude)
      googleMap.clear()
      googleMap.addMarker(MarkerOptions().position(latLng))
      googleMap.addCircle(CircleOptions()
        .center(latLng)
        .radius(50000.0) // 50 km radius
        .strokeColor(0x220000FF)
        .fillColor(0x220000FF)
        .strokeWidth(5f))
      googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
    }
  }
}


class OSMMapManager(private val context: Context) : MapManager {
  private lateinit var osmMapView: OSMMapView
  private var userLocation: Location? = null

  override fun initialize(context: Context): FrameLayout {
    Configuration.getInstance().load(context, android.preference.PreferenceManager.getDefaultSharedPreferences(context))
    osmMapView = OSMMapView(context)
    osmMapView.setMultiTouchControls(true)

    val frameLayout = FrameLayout(context)
    frameLayout.addView(osmMapView)
    return frameLayout
  }

  override fun updateLocation(location: Location) {
    userLocation = location
    if (this::osmMapView.isInitialized) {
      val geoPoint = GeoPoint(location.latitude, location.longitude)
      osmMapView.controller.setZoom(9.5)
      osmMapView.controller.setCenter(geoPoint)
      osmMapView.overlays.clear()

      val startMarker = Marker(osmMapView)
      startMarker.position = geoPoint
      startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
      osmMapView.overlays.add(startMarker)

      // Calculate points for a 50km radius circle
      val radiusMeters = 50000.0
      val points = mutableListOf<GeoPoint>()
      val numPoints = 360
      val center = GeoPoint(geoPoint.latitude, geoPoint.longitude)
      val radiusDegrees = metersToDegrees(radiusMeters, geoPoint.latitude)

      for (i in 0 until numPoints) {
        val angle = (2 * PI * i / numPoints).toFloat()
        val lat = center.latitude + radiusDegrees * sin(angle.toDouble())
        val lon = center.longitude + radiusDegrees * cos(angle.toDouble()) / cos(center.latitude * PI / 180)
        points.add(GeoPoint(lat, lon))
      }

      val radiusOverlay = Polygon().apply {
        this.points = points
        fillPaint.color = 0x220000FF // Fill color
        fillPaint.alpha = 128 // Transparency
        outlinePaint.color = 0x220000FF // Outline color
        outlinePaint.alpha = 128 // Transparency
      }
      osmMapView.overlays.add(radiusOverlay)
      osmMapView.invalidate() // Refresh the map view
    }
  }

  private fun metersToDegrees(meters: Double, latitude: Double): Double {
    return meters / (111.32 * 1000 * cos(latitude * PI / 180))
  }
}











