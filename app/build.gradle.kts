plugins {
    alias(libs.plugins.android_application)
    alias(libs.plugins.kotlin_android)
    alias(libs.plugins.hilt)
    kotlin("kapt") // Wichtig für Annotation Processing
}

android {
    namespace = "com.example.secureapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.secureapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.hilt_android)
    kapt(libs.hilt_compiler)
    implementation(libs.room_runtime)
    kapt(libs.room_compiler)
}
