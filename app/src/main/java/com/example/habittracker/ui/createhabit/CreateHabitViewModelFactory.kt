package com.example.habittracker.ui.createhabit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.data.repository.HabitRepository

class CreateHabitViewModelFactory(
    private val repository: HabitRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(CreateHabitViewModel::class.java)) {

            return CreateHabitViewModel(repository) as T

        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}