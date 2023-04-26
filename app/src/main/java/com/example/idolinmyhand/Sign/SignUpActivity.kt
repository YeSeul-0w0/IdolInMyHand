package com.example.idolinmyhand.Sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.idolinmyhand.MainActivity
import com.example.idolinmyhand.databinding.ActivitySignupBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null

    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.signUp.setOnClickListener {
            val email = binding.email.text.toString()
            val passwd = binding.password.text.toString()
            val checkPasswd = binding.passwordCheck.text.toString()
            signUp(email, passwd, checkPasswd)
        }
    }

     fun signUp(email:String, password:String, checkPasswd:String) {
         if (password == checkPasswd){
             auth?.createUserWithEmailAndPassword(email, password)
                 ?.addOnCompleteListener {
                         task ->
                     if(task.isSuccessful) {
                         // Creating a user account
                         startActivity(Intent(this, MainActivity::class.java))
                     } else {
                         // Show the error message
                         Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                     }
                 }
         }
         else{
             Toast.makeText(this, "비밀번호가 일치하지 않습니다.ㅡ", Toast.LENGTH_LONG).show()
         }
     }
}

