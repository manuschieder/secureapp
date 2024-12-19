package com.example.secureapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey val id: Int,
    val colorScheme: String,
    val notificationsEnabled: Boolean
)
