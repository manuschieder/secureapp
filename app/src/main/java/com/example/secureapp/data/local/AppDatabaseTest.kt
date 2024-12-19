package com.example.secureapp.data.local

import androidx.room.Entity;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: UserPreferencesDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val passphrase = SQLiteDatabase.getBytes("test_passphrase".toCharArray())
        val factory = SupportFactory(passphrase)

        db = androidx.room.Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "test_database.db"
        )
            .openHelperFactory(factory)
            .allowMainThreadQueries()
            .build()

        dao = db.userPreferencesDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun testInsertAndRetrievePreferences() = runBlocking {
        val preferences = UserPreferences(1, "#FF0000", true)
        dao.savePreferences(preferences)

        val retrievedPreferences = dao.getPreferences(1)
        assertEquals(preferences.colorScheme, retrievedPreferences?.colorScheme)
        assertEquals(preferences.notificationsEnabled, retrievedPreferences?.notificationsEnabled)
    }

    @Test
    fun testDeletePreferences() = runBlocking {
        val preferences = UserPreferences(2, "#00FF00", false)
        dao.savePreferences(preferences)

        dao.deletePreferences(preferences)

        val retrievedPreferences = dao.getPreferences(2)
        assertEquals(null, retrievedPreferences)
    }
}
