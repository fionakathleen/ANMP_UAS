package com.example.habittracker.data.repository

import com.example.habittracker.data.local.UserDao
import com.example.habittracker.data.model.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun login(
        username: String,
        password: String
    ): User? {

        return userDao.login(username, password)

    }

    suspend fun createDefaultUser() {

        if (userDao.countUser() == 0) {

            userDao.insertUser(

                User(
                    username = "student",
                    password = "123"
                )

            )

        }

    }

}