package com.example.habittracker.ui.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.data.local.HabitDatabase
import com.example.habittracker.data.repository.UserRepository

class LoginViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        val repository = UserRepository(
            HabitDatabase
                .getDatabase(application)
                .userDao()
        )

        return LoginViewModel(repository) as T

    }

}