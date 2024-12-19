package com.example.secureapp.data

import com.example.secureapp.data.local.AppDatabase
import com.example.secureapp.data.local.UserPreferences
import com.example.secureapp.data.remote.ApiService
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService // Retrofit-Service für die API-Kommunikation
) {

    // Login-Methode für die API
    suspend fun login(username: String, password: String): Boolean {
        val response = apiService.login(mapOf("username" to username, "password" to password))
        return response.isSuccessful // Rückmeldung, ob der Login erfolgreich war
    }

    // Lokale Datenbankoperationen
    suspend fun savePreferences(preferences: UserPreferences) {
        database.userPreferencesDao().savePreferences(preferences)
    }

    suspend fun getPreferences(id: Int): UserPreferences? {
        return database.userPreferencesDao().getPreferences(id)
    }

    suspend fun deletePreferences(preferences: UserPreferences) {
        database.userPreferencesDao().deletePreferences(preferences)
    }
}
