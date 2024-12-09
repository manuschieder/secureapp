package com.example.secureapp.data.remote

data class LoginResponse(
    val token: String, // Das Access Token
    val expiresIn: Int? = null, // Optional: Ablaufzeit des Tokens
    val refreshToken: String? = null // Optional: Refresh Token
)
