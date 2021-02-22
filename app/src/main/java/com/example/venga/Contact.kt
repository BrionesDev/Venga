package com.example.venga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.firebase.ui.auth.AuthUI


enum class ProviderType {
    BASIC
}

class Contact : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        auth = Firebase.auth

        findViewById<Button>(R.id.buttonContact).setOnClickListener() {
            val intent = Intent(this, Contact::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.buttonChat).setOnClickListener() {
            val intent = Intent(this, Message::class.java)
            startActivity(intent)
            this.finish()
        }

        //Log out
        findViewById<Button>(R.id.buttonSettings).setOnClickListener {
            AuthUI.getInstance().signOut(this).addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(baseContext, "LOGOUT", Toast.LENGTH_LONG).show()
                /*val builder = AlertDialog.Builder(this)
                builder.setTitle("LogOut")
                builder.setMessage("Has cerrado sesión correctamente!!")
                builder.setPositiveButton("Aceptar", null)
                val dialog: AlertDialog = builder.create()
                dialog.show()*/
                this.finish()
            }
        }
    }
}