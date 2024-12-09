class AppRepository(
    private val apiService: ApiService,
    private val userPreferencesDao: UserPreferencesDao
) {
    suspend fun login(username: String, password: String): LoginResponse {
        return apiService.login(mapOf("username" to username, "password" to password))
    }

    suspend fun saveUserPreferences(preferences: UserPreferences) {
        userPreferencesDao.savePreferences(preferences)
    }

    suspend fun getUserPreferences(): UserPreferences? {
        return userPreferencesDao.getPreferences(0)
    }
}
