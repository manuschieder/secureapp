// Projektweite Gradle-Build-Datei
plugins {
    alias(libs.plugins.android.application) apply false // Android Application Plugin
    alias(libs.plugins.kotlin.android) apply false // Kotlin Plugin
    alias(libs.plugins.hilt) apply false // Hilt Plugin (falls verwendet)
}

allprojects {
    repositories {
        google() // Google Repository
        mavenCentral() // Maven Central Repository
    }
}

// Task, um das Projekt zu bereinigen
tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
