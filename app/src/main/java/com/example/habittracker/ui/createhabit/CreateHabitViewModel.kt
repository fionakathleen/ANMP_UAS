package com.example.habittracker.ui.createhabit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.repository.HabitRepository
import kotlinx.coroutines.launch

class CreateHabitViewModel(
    private val repository: HabitRepository
) : ViewModel() {

    fun addHabit(habit: Habit) {

        viewModelScope.launch {

            repository.insertHabit(habit)

        }
    }
}