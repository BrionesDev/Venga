package com.example.venga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


@Suppress("UNREACHABLE_CODE")
class addContact : AppCompatActivity(), View.OnClickListener {

    private var addBtn: Button? = null
    private var nameField: EditText? = null
    private var mailField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        addBtn = findViewById(R.id.add)

    }

    private fun sendData(usr: User) {
        val send = Intent(this@addContact, Contact::class.java)
        val bundle = Bundle()
        bundle.putSerializable("serializable", usr)
        send.putExtras(bundle)
        startActivity(send)
    }

    override fun onClick(v: View?) {
        TODO("to implement")
        addBtn?.setOnClickListener {
            if (TextUtils.isEmpty(nameField?.text.toString()) && TextUtils.isEmpty(mailField?.text.toString())) {
                Toast.makeText(this, "Commprueba los datos introducidos", Toast.LENGTH_LONG).show()
            } else {
                val User = User("","")
                User.setMail(mailField?.text.toString())
                User.setName(nameField?.text.toString())
                sendData(User)
                Toast.makeText(this, "Datos introducidos correctamente", Toast.LENGTH_LONG).show()
            }
        }
    }
}
