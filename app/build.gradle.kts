plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin") // Hilt-Plugin für Dependency Injection
}

android {
    namespace = "com.example.secureapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.secureapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Auth0 spezifische Platzhalter
        manifestPlaceholders["auth0Domain"] = "dev-hl22whbugwmmvwan.us.auth0.com" // Deine Auth0-Domain
        manifestPlaceholders["auth0Scheme"] = "demo" // Dein Auth0-Schema
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Android Lifecycle und LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Room (Datenbank)
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    // SQLCipher (Verschlüsselung für Room)
    implementation("net.zetetic:android-database-sqlcipher:4.5.3")

    // Retrofit (API-Aufrufe)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp (HTTP-Client)
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    // Auth0 (OAuth2-Integration)
    implementation("com.auth0.android:auth0:2.8.0")
    implementation("com.auth0.android:jwtdecode:2.0.0")

    // Navigation (Fragments)
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.1")

    // AndroidX Security (Schlüsselableitung und Verschlüsselung)
    implementation("androidx.security:security-crypto:1.1.0-alpha06")

    // Dependency Injection (Hilt)
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")

    // Testen
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
