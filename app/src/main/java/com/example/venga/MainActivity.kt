package com.example.venga

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//import com.google.firebase.quickstart.auth.R
//import com.google.firebase.quickstart.auth.databinding.ActivityEmailpasswordBinding

/**
 * Main activity y autores de la aplicación
 *
 * @constructor Crea un constructor vacío en Main activity
 * @author Elian Briones y Christian Caballero
 */

class MainActivity : AppCompatActivity() {
    /**
     * On create
     *
     * @param savedInstanceState es una instancia de Bundle. Esta clase mapea claves String a valores
     * 'Parcelable'
     * @see Bundle
     */

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        /**
         * Enlazamos cada uno de los botones mediante la función setOnClickListener() y la cerramos
         * utilizando this.finish()
         */
        auth = Firebase.auth

        findViewById<Button>(R.id.signUpButton).setOnClickListener() {
            val intent = Intent(this, Registry::class.java)
            startActivity(intent)
            this.finish()
        }

        //findViewById<Button>(R.id.loginButton).setOnClickListener() {
        //      val intent = Intent(this, Contact::class.java)
        // startActivity(intent)
        // this.finish()
        // }

        // Setup
        logIn()
    }

    private fun hasData() : Boolean
    {
        return !(TextUtils.isEmpty(findViewById<EditText>(R.id.etIngreso2).text.toString()) &&
                TextUtils.isEmpty(findViewById<EditText>(R.id.etIngreso).text.toString()))
    }

    private fun getEmail() : String
    {
        return findViewById<EditText>(R.id.etIngreso2).text.toString()
    }

    private fun getPassword() : String
    {
        return findViewById<EditText>(R.id.etIngreso).text.toString()
    }

    private fun logIn() {
        title = "Autenticación"

        findViewById<Button>(R.id.loginButton).setOnClickListener {

            if (hasData()) {
                auth.signInWithEmailAndPassword(getEmail(), getPassword())
                    .addOnCompleteListener(this) { tasca_login ->
                        if (tasca_login.isSuccessful) {
                            showSuccessful()
                            showContact(tasca_login.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            } else {
                showAlertNoInput()
            }
        }

        //Lo mismo pero con registerButton
        findViewById<Button>(R.id.signUpButton).setOnClickListener {

            if (hasData()) {
                auth.createUserWithEmailAndPassword(getEmail(), getPassword())
                    .addOnCompleteListener(this) { tasca_login ->
                        if (tasca_login.isSuccessful) {
                            showSuccessful2()
                        } else {
                            showAlert2()
                        }
                    }
            } else {
                showAlertNoInput()
            }
        }
    }



    private fun showData(user: String, password : String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Datos")
        builder.setMessage(user + " " + password)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlert2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage("Se ha introducido datos incorrectos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertNoInput() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage("Rellene los campos de usuario y contraseña")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showSuccessful() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ACEPTADO")
        builder.setMessage("Usuario logueado correctamente!!")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showSuccessful2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("REGISTRO COMPLETADO")
        builder.setMessage("Usuario registrado correctamente!!")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showContact(email: String, provider: ProviderType) {
        val contactIntent = Intent(this, Contact::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(contactIntent)
    }

}