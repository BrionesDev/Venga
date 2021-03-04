package com.example.venga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.firebase.ui.auth.AuthUI
import com.google.firebase.firestore.FirebaseFirestore

enum class ProviderType {
    BASIC
}

class Contact() : AppCompatActivity() {

    private var arrayContacts: ArrayList<User>? = null
    private var db: FirebaseFirestore? = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    private var mail: TextView? = null
    private var name: TextView? = null
    private var listView: ListView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        auth = Firebase.auth

        arrayContacts = ArrayList()

        loadDataListView()

        //++++AQUI ME HE QUEDADO LISTVIEW Y SEGUIMOS
        //listView = findViewById(R.id.listView)

        //++++ .add y meter get y set
        //arrayContacts.add()


        
        // Ejercicio 3. Mostrar email en esta pestaña
        val currentUser = Firebase.auth.currentUser
        val userMail = findViewById<TextView>(R.id.emailContact)
        userMail.text = currentUser?.email!!.trim().substringBefore("@")

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

        findViewById<Button>(R.id.addbtn).setOnClickListener {
           val intent = Intent(this, addContact::class.java)
           startActivity(intent)
           this.finish()
        }
    }

    private fun loadDataListView() {
        db!!.collection("contacts").get()
                .addOnSuccessListener {queryDocumentSnapshots ->
                    if (!queryDocumentSnapshots.isEmpty) {
                        val list = queryDocumentSnapshots.documents
                        for (i in list) {
                            val mail = list.get(0).data?.get("mail").toString()
                            val name = list.get(0).data?.get("password").toString()
                            val user: User? = i.toObject(User(mail, name)::class.java)

                            if (user != null) {
                                arrayContacts?.add(user)
                            }
                        }
                    } else {
                        Toast.makeText(this@Contact, "Información no encontrada en la base de datos", Toast.LENGTH_SHORT).show()
                    }
                } .addOnFailureListener {
                    Toast.makeText(this@Contact, "Error al cargar la información", Toast.LENGTH_SHORT).show()
                }
    }
}