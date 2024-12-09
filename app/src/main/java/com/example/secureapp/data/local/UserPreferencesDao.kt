import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM user_preferences WHERE id = :id")
    suspend fun getPreferences(id: Int): UserPreferences?

    @Insert
    suspend fun savePreferences(preferences: UserPreferences)
}
