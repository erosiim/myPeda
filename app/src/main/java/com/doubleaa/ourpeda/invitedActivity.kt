package com.doubleaa.ourpeda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_invited.*

class invitedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invited)

        btnRegistroInvitados.setOnClickListener {
            Toast.makeText(this,"Bienvenido INVITADO", Toast.LENGTH_LONG).show()
            val intent = Intent (this, InvitadoMain::class.java)
            startActivity(intent)
            finish()
        }

    }


}
