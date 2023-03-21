package com.example.idolinmyhand.Sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idolinmyhand.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}