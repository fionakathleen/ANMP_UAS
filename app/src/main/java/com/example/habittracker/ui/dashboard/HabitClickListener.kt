package com.example.habittracker.ui.dashboard

import com.example.habittracker.data.model.Habit

interface HabitClickListener {

    fun onHabitClick(habit: Habit)

    fun onPlusClick(habit: Habit)

    fun onMinusClick(habit: Habit)

}