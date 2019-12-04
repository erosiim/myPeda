package com.doubleaa.ourpeda

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


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
