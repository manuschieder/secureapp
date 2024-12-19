package com.example.secureapp.di

import android.content.Context
import com.example.secureapp.data.local.AppDatabase
import com.example.secureapp.data.remote.ApiService
import com.example.secureapp.data.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context, "default_passphrase")
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://your-backend.com/api/") // Setze die Backend-URL ein
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(database: AppDatabase, apiService: ApiService): AppRepository {
        return AppRepository(database, apiService)
    }
}
