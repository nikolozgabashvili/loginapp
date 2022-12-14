package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var gmail:EditText
    private lateinit var password:EditText
    private lateinit var button: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gmail = findViewById(R.id.gmail)
        password = findViewById(R.id.pass)
        button = findViewById(R.id.button)
        
        
        button.setOnClickListener { 
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(gmail.text.toString(),password.text.toString())
                .addOnCompleteListener{task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
                    }
                
            }.addOnFailureListener {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
            
        }

    }
}