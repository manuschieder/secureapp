package com.example.secureapp.ui.home


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
import com.example.secureapp.ui.login.LoginActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var auth0: Auth0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Auth0 initialisieren
        auth0 = Auth0(
            "D4QiGhiQBsZpB43Ke40H7IMYcpLeOA4b",
            "dev-hl22whbugwmmvwan.us.auth0.com"
        )

        // Logout-Button einrichten
        val logoutButton = findViewById<Button>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            logoutFromAuth0()
        }
    }

    private fun logoutFromAuth0() {
        WebAuthProvider.logout(auth0)
            .withScheme("demo")
            .start(this, object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    Log.d("Auth0", "Logout erfolgreich")

                    // Zurück zur LoginActivity
                    val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(exception: AuthenticationException) {
                    Log.e("Auth0", "Logout fehlgeschlagen: ${exception.message}")
                }
            })
    }
}
