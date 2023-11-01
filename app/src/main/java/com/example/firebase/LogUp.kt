package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_up)

        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)?.text.toString()
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)?.text.toString()
        val buttonSigIn = findViewById<Button>(R.id.buttonSigIn)
        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)

        buttonSignUp.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmail, editTextPassword).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show()
                } else {
                    // Hubo un error al registrar al usuario, puedes manejar el error aquí
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        buttonSigIn.setOnClickListener{
            val intent = Intent(this,LogIng::class.java)
            startActivity(intent)
        }
    }
}