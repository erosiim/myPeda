package com.doubleaa.ourpeda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.loginScreen)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * Pasamos a nueva actividad a través del botón host (llamamos directo al botón host)
        * */
        /*
        * Actividad de login a host
        * */
        btnHost.setOnClickListener{
            val intent = Intent (this, hostActivity::class.java)
            startActivity(intent)
        }
        /*
        * Actividad de login a invitado
        * */
        btnInvitado.setOnClickListener {
            val intent = Intent (this, invitedActivity::class.java)
            startActivity(intent)
        }


    }

}
