package com.example.habittracker.ui.edithabit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.repository.HabitRepository
import kotlinx.coroutines.launch

class EditHabitViewModel(
    private val repository: HabitRepository
) : ViewModel() {

    private var currentHabit: Habit? = null

    val name = MutableLiveData("")
    val description = MutableLiveData("")
    val goal = MutableLiveData("")
    val unit = MutableLiveData("")
    val icon = MutableLiveData<Int>()

    fun getHabitById(id: Int): LiveData<Habit> {
        return repository.getHabitById(id)
    }

    fun setHabit(habit: Habit) {

        currentHabit = habit

        name.value = habit.name
        description.value = habit.description
        goal.value = habit.goal.toString()
        unit.value = habit.unit
        icon.value = habit.icon
    }

    fun updateHabit() {

        currentHabit?.let {

            it.name = name.value ?: ""
            it.description = description.value ?: ""
            it.goal = goal.value?.toIntOrNull() ?: 0
            it.unit = unit.value ?: ""

            viewModelScope.launch {
                repository.updateHabit(it)
            }
        }
    }
}