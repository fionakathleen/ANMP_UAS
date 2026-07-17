package com.example.habittracker.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.habittracker.data.model.Habit

@Dao
interface HabitDao {

    @Query("SELECT * FROM habits ORDER BY id DESC")
    fun getAllHabits(): LiveData<List<Habit>>

    @Query("SELECT * FROM habits WHERE id = :id")
    fun getHabitById(id: Int): LiveData<Habit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)
}