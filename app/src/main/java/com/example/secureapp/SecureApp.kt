package com.example.secureapp

import android.app.Application
import com.example.secureapp.data.local.AppDatabase
import com.example.secureapp.utils.EncryptionHelper

@HiltAndroidApp
class SecureApp : Application() {

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        // Beispiel: Generiere ein Salt und leite den Schlüssel ab
        val userPassword = "user_password" // Beispiel für das Benutzerpasswort
        val salt = EncryptionHelper.generateSalt()
        val passphrase = EncryptionHelper.deriveKeyFromPassword(userPassword, salt)

        // Initialisiere die verschlüsselte Datenbank
        database = AppDatabase.getDatabase(this, passphrase)
    }
}
