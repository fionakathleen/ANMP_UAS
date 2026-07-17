package com.example.habittracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val icon: Int,

    var name: String,

    var description: String,

    var goal: Int,

    var unit: String,

    var progress: Int = 0
)