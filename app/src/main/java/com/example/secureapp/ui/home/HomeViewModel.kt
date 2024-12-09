package com.example.secureapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    fun fetchWelcomeMessage() {
        viewModelScope.launch {
            // Simulierter Datenabruf (dies könnte aus einem Repository kommen)
            _message.value = "Willkommen in der sicheren App!"
        }
    }
}
