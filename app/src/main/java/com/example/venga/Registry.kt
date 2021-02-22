package com.example.venga

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

/**
 * Registry y autores de la aplicación
 *
 * @constructor Crea actividad Registry con constructor vacío
 * @author Elian Briones Victores y Christian Caballero Charnicharo
 */
class Registry : AppCompatActivity() {
    /**
     * On create
     *
     * @param savedInstanceState Instancia de la clase Bundle. Esta clase mapea claves String a valores
     * 'Parcelable'
     * @see Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre)
        /**
         * Enlazamos el botón con setOnClickListener() y cerramos con this.finish().
         */
        findViewById<Button>(R.id.buttonFinalizar).setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        }
    }
