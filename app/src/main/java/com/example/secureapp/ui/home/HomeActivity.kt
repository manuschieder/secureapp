package com.example.secureapp.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.secureapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Datenbindung initialisieren
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Beobachten von LiveData aus dem ViewModel
        homeViewModel.message.observe(this, Observer { message ->
            binding.textViewWelcome.text = message
        })

        // Beispiel für Datenabruf
        homeViewModel.fetchWelcomeMessage()
    }
}
