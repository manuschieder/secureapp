package com.example.secureapp.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

// Schnittstelle für API-Endpunkte
interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: Map<String, String>): LoginResponse
}
