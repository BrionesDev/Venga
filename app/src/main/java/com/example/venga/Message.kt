package com.example.venga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

/**
 * Message y autores de la aplicación
 *
 * @constructor Crea un constructor vacío de la actividad Message
 * @author Elian Briones y Christian Caballero
 */
class Message : AppCompatActivity() {
    /**
     * On create
     *
     * @param savedInstanceState Instancia de Bundle. Esta clase mapea claves String a valores
     * 'Parcelable'
     * @see Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        /**
         * Enlazamos cada botón hacia una actividad y la cerramos
         * @param go1 Cada botón 'go' lleva hacia un determinado chat
         */
        findViewById<Button>(R.id.go1).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.go2).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.go3).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.go4).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.go5).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.go6).setOnClickListener() {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
            this.finish()
        }

        /**
         * @param buttonContactM cada botón lleva hacia las diferentes pantallas de la aplicación.
         * @param buttonChatM
         * @param buttonSettingsM
         */

        findViewById<Button>(R.id.buttonContactM).setOnClickListener() {
            val intent = Intent(this, Contact::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.buttonChatM).setOnClickListener() {
            val intent = Intent(this, Message::class.java)
            startActivity(intent)
            this.finish()
        }

        findViewById<Button>(R.id.buttonSettingsM).setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()

        }
    }
}