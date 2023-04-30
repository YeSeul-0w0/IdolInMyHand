package com.example.idolinmyhand.Sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.idolinmyhand.MainActivity
import com.example.idolinmyhand.databinding.ActivityCreateprofileBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class CreateProfileActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    val db = Firebase.firestore
    val storage = Firebase.storage

    private val binding by lazy {
        ActivityCreateprofileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        println("list, "+getIdolList())
//        auth = FirebaseAuth.getInstance()
//        binding.signUp.setOnClickListener {
//            val email = binding.email.text.toString()
//            val passwd = binding.password.text.toString()
//            val checkPasswd = binding.passwordCheck.text.toString()
//            signUp(email, passwd, checkPasswd)
//        }
    }

    fun getIdolList(): MutableList<String> {
        var idolList = mutableListOf<String>()
        val field = db.collection("list").document("idol")
        field.get()
            .addOnSuccessListener { document ->
                if (document != null){
                    val temp =  document.data
                    for (i: Int in 1..4){
                        idolList.add(temp?.getValue(i.toString()).toString())
                    }
                }
                else{
                    println("test")
                }
            }
            .addOnFailureListener {exception->
                Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
            }
        return idolList;
    }

//     fun signUp(email:String, password:String, checkPasswd:String) {
//         if (password == checkPasswd){
//             auth?.createUserWithEmailAndPassword(email, password)
//                 ?.addOnCompleteListener {
//                         task ->
//                     if(task.isSuccessful) {
//                         // Creating a user account
//                         startActivity(Intent(this, MainActivity::class.java))
//                     } else {
//                         // Show the error message
//                         Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
//                     }
//                 }
//         }
//         else{
//             Toast.makeText(this, "비밀번호가 일치하지 않습니다.ㅡ", Toast.LENGTH_LONG).show()
//         }
//     }
}

