package com.example.secureapp.data.local

import androidx.room.*

@Dao
interface UserPreferencesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePreferences(preferences: UserPreferences)

    @Query("SELECT * FROM user_preferences WHERE id = :id")
    suspend fun getPreferences(id: Int): UserPreferences?

    @Delete
    suspend fun deletePreferences(preferences: UserPreferences)
}
