package com.example.idolinmyhand.Sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.idolinmyhand.MainActivity
import com.example.idolinmyhand.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.login.setOnClickListener {
            val email = binding.email.text.toString()
            val passwd = binding.password.text.toString()
            login(email, passwd)
        }
    }
     fun login(email:String, password:String) {
         auth?.signInWithEmailAndPassword(email,password) // 로그인
             ?.addOnCompleteListener {
                     result->
                 if(result.isSuccessful){
                     val intent = Intent(this, MainActivity::class.java)
                     startActivity(intent)
                 } else{
                     Toast.makeText(this, result.exception?.message, Toast.LENGTH_LONG).show()
                 }
             }
     }
//    fun moveMainPage(user: FirebaseUser?){
//        if( user!= null){
//            startActivity(Intent(this,MainActivity::class.java))
//            finish()
//        }
//    }
}

