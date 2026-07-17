package com.example.habittracker.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.MainActivity
import com.example.habittracker.R

class LoginActivity : AppCompatActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // TODO:
        // gunakan ViewModelFactory karena LoginViewModel memiliki constructor repository
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(application)
        )[LoginViewModel::class.java]

        btnLogin.setOnClickListener {

            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if(username.isEmpty() || password.isEmpty()){

                Toast.makeText(
                    this,
                    "Semua field harus diisi",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            viewModel.login(
                username,
                password
            )

        }

        viewModel.loginResult.observe(this){

            if(it != null){

                startActivity(
                    Intent(this, MainActivity::class.java)
                )

                finish()

            }else{

                Toast.makeText(
                    this,
                    "Username atau password salah",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }
    }
}