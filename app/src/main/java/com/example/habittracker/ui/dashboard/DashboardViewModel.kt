package com.example.habittracker.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.repository.HabitRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: HabitRepository
) : ViewModel() {

    val habits: LiveData<List<Habit>> =
        repository.getAllHabits()

    fun incrementProgress(habit: Habit) {

        if (habit.progress < habit.goal) {

            val updatedHabit = habit.copy(
                progress = habit.progress + 1
            )

            viewModelScope.launch {
                repository.updateHabit(updatedHabit)
            }
        }
    }

    fun decrementProgress(habit: Habit) {

        if (habit.progress > 0) {

            val updatedHabit = habit.copy(
                progress = habit.progress - 1
            )

            viewModelScope.launch {
                repository.updateHabit(updatedHabit)
            }
        }
    }
}