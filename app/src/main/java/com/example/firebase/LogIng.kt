package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIng : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_ing)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)?.text.toString()
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)?.text.toString()
        val buttonSigIn = findViewById<Button>(R.id.buttonSigIn)
        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)
        buttonSigIn.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextEmail, editTextPassword).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso, puedes redirigir al usuario a la pantalla principal u otra actividad
                    Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // Hubo un error al iniciar sesión, puedes manejar el error aquí
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }
        buttonSignUp.setOnClickListener{
            val intent = Intent(this,LogUp::class.java)
            startActivity(intent)
        }

    }
}