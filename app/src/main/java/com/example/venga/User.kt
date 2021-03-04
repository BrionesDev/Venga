package com.example.venga

import java.io.Serializable

class User : Serializable {
    var sMail: String? = null
    var sName: String? = null

    constructor()
    {

    }

    constructor(mail: String?, name: String?) {
        this.sMail = mail
        this.sName = name
    }

    fun getMail(): String? {
        return sMail
    }

    fun setMail(mail: String) {
        this.sMail = mail
    }

    fun getName(): String? {
        return sName
    }

    fun setName(name: String) {
        this.sName = name
    }


}
