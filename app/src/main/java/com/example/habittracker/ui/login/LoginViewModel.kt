package com.example.habittracker.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.User
import com.example.habittracker.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val loginResult = MutableLiveData<User?>()

    init {
        viewModelScope.launch {
            repository.createDefaultUser()
        }
    }

    fun login(
        username: String,
        password: String
    ) {

        viewModelScope.launch {

            val user = repository.login(
                username,
                password
            )

            loginResult.postValue(user)

        }

    }

}