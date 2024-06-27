import java.util.Properties

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
  id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}


android {
  namespace = "com.example.farmersmarket"
  compileSdk = 34

  buildFeatures {
    buildConfig = true
  }

  defaultConfig {

    applicationId = "com.example.farmersmarket"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }

    // Load API key from apikey.properties
    val apikeyPropertiesFile = project.rootProject.file("apikeys.properties")
    val apikeyProperties = Properties()
    apikeyProperties.load(apikeyPropertiesFile.inputStream())

    // Get API_KEY property value, defaulting to empty string if not found
    val apiKey = apikeyProperties.getProperty("API_KEY") ?: ""

    // Add API_KEY as a BuildConfig field
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    manifestPlaceholders["GOOGLE_API_KEY"] = apiKey

  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  // Mapbox Maps SDK
  implementation(libs.plugin.gestures)
  implementation(libs.plugin.compose)
  implementation(libs.android)
  implementation(libs.mapbox.android.sdk)

  implementation(libs.play.services.maps.v1802)
  implementation(libs.osmdroid.android)

  // KTX for the Maps SDK for Android
  implementation(libs.maps.ktx)
  // KTX for the Maps SDK for Android Utility Library
  implementation(libs.maps.utils.ktx)

  //Lifecycle
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.lifecycle.runtime.compose)

  //Google Services & Maps
  implementation(libs.play.services.location)
  implementation(libs.maps.compose.v290)
  implementation(libs.play.services.maps)

  //Accompanist (Permission)
  implementation(libs.accompanist.permissions)

  // Hilt and Compose Integration
  implementation(libs.androidx.hilt.navigation.compose)

  //Hilt
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.accompanist.permissions.v0300)

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation(libs.androidx.navigation.compose)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}