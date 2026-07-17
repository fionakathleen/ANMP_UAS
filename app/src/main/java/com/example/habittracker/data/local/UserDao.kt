package com.example.habittracker.data.local

import androidx.room.*
import com.example.habittracker.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username=:username AND password=:password LIMIT 1")
    suspend fun login(
        username: String,
        password: String
    ): User?

    @Query("SELECT COUNT(*) FROM users")
    suspend fun countUser(): Int
}