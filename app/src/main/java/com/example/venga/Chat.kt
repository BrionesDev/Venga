package com.example.venga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * Chat y autores de la aplicación
 *
 * @constructor Crea un constructor vacío de la actividad Chat
 * @author Elian Briones y Christian Caballero
 */
class Chat : AppCompatActivity() {
    /**
     * On create
     *
     * @param savedInstanceState Instancia de la clase Bundle. Esta clase mapea claves String a valores
     * 'Parcelable'
     * @see Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        /**
         * @param goBack Este botón se dirigirá de vuelta a la pantalla del listado de mensajes
         */
        findViewById<Button>(R.id.goBack).setOnClickListener() {
            val intent = Intent(this, Message::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}