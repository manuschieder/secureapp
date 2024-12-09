package com.example.secureapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.auth0.android.Auth0
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.authentication.AuthenticationException
import com.example.secureapp.R
import com.example.secureapp.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var auth0: Auth0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Auth0 initialisieren
        auth0 = Auth0(
            "D4QiGhiQBsZpB43Ke40H7IMYcpLeOA4b", // Deine Client-ID
            "dev-hl22whbugwmmvwan.us.auth0.com" // Deine Auth0-Domain
        )

        // Login-Button einrichten
        val loginButton = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener {
            loginWithAuth0()
        }
    }

    private fun loginWithAuth0() {
        WebAuthProvider.login(auth0)
            .withScheme("demo") // Muss in der Manifest-Datei angegeben werden
            .start(this, object : Callback<Credentials, AuthenticationException> {
                override fun onSuccess(credentials: Credentials) {
                    // Token speichern
                    saveToken(credentials.accessToken)
                    Log.d("Auth0", "Login erfolgreich! Access Token: ${credentials.accessToken}")

                    // Zur HomeActivity wechseln
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(exception: AuthenticationException) {
                    Log.e("Auth0", "Login fehlgeschlagen: ${exception.message}")
                }
            })
    }

    private fun saveToken(token: String?) {
        token?.let {
            getSharedPreferences("auth0_prefs", MODE_PRIVATE)
                .edit()
                .putString("access_token", it)
                .apply()
        }
    }
}
