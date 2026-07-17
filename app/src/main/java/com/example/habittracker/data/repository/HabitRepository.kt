package com.example.habittracker.data.repository

import androidx.lifecycle.LiveData
import com.example.habittracker.data.local.HabitDao
import com.example.habittracker.data.model.Habit

class HabitRepository(
    private val habitDao: HabitDao
) {

    fun getAllHabits() =
        habitDao.getAllHabits()

    suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun updateHabit(habit: Habit) {
        habitDao.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: Habit) {
        habitDao.deleteHabit(habit)
    }

    fun getHabitById(id: Int): LiveData<Habit> {
        return habitDao.getHabitById(id)
    }

}