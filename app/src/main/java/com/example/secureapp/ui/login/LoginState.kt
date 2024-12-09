package com.example.secureapp.ui.login

// LoginState modelliert den Status des Login-Vorgangs
sealed class LoginState {
    object Success : LoginState() // Login erfolgreich
    data class Error(val message: String) : LoginState() // Fehler mit einer Nachricht
}
