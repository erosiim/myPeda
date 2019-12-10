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
import com.doubleaa.ourpeda.APIInterfaceRequest.IHostApiService
import com.doubleaa.ourpeda.HttpBodyPojos.HostBodyPojo
import com.doubleaa.ourpeda.HttpResponsePojos.HostResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.sql.DriverManager


class MainActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder().addCallAdapterFactory(
        RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://mipeda.appspot.com/")
        .build()




    var retrofitobj = retrofit.create(IHostApiService::class.java)




    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.loginScreen)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIngresarMain.setOnClickListener {
            val intent = Intent (this, hostActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Bienvenido ${txtUsuario.text.toString()}" , Toast.LENGTH_LONG).show()
        }


      /*  val retrofit = Retrofit.Builder().addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl("https://mipeda.appspot.com/")
            .build();

        var retrofitobj = retrofit.create(IHostApiService::class.java)

        //INICIA GET TODOS
        retrofitobj.getHosts().enqueue(
            object : Callback<ArrayList<HostResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<HostResponse>>,
                    response: Response<ArrayList<HostResponse>>
                ) {
                    response.body()!!.map {
                        value: HostResponse -> Log.d("RESPONSE", value.usuario)
                    }
                    Log.d("RESPONSE", response.body().toString())
                    var t = Toast.makeText(this@MainActivity, "Goood", Toast.LENGTH_LONG)
                    t.show()
                }

                override fun onFailure(call: Call<ArrayList<HostResponse>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }

        )
        // TERMINA GET

        //INICIA GET ONE
        retrofitobj.getHostById("4").enqueue(
            object : Callback<HostResponse> {
                override fun onFailure(call: Call<HostResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<HostResponse>,
                    response: Response<HostResponse>
                ) {
                    Log.d("I FOUND "+ response.body()?.nombre, "I FOUND "+ response.body()?.nombre)
                    var t = Toast.makeText(this@MainActivity, "Goood", Toast.LENGTH_LONG)
                    t.show()
                }

            }
        )
        //TERMINA GET ONE

        //INICIA POST
        var newHost = HostBodyPojo()
        newHost.contrasena = "AllMight"
        newHost.usuario = "aldairmh4"
        newHost.direccion = "Orizaba, VEr"
        newHost.edad = "100"
        newHost.nombre = "Alda4"
        newHost.telefono= "12"
        newHost.image = "notengo"
        retrofitobj.createHost(newHost).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@MainActivity, "ERROR ADDING", Toast.LENGTH_LONG)
                    t.show()
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@MainActivity, "ADDED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }

            }

        )

        // TERMINA POST

        newHost.nombre = "ALONSO"
        //INICIA PUT
        retrofitobj.updateHost("4", newHost ).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@MainActivity, "ERROR UPDATING", Toast.LENGTH_LONG)
                    t.show()
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@MainActivity, "UPDATED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }
            }
        )
        //TERMINA PUT

        //INICIA DELETE

        retrofitobj.deleteHost("6").enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@MainActivity, "ERROR DELETING", Toast.LENGTH_LONG)
                    t.show()
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@MainActivity, "DELETED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }
            }
        )
        // TERMINA DELETE
*/


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

    fun login(){
        //INICIA GET ONE
        retrofitobj.getHostById("4").enqueue(
            object : Callback<HostResponse> {
                override fun onFailure(call: Call<HostResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<HostResponse>,
                    response: Response<HostResponse>
                ) {
                    Log.d("I FOUND "+ response.body()?.nombre, "I FOUND "+ response.body()?.nombre)
                    var t = Toast.makeText(this@MainActivity, "Goood", Toast.LENGTH_LONG)
                    t.show()
                }

            }
        )
        //TERMINA GET ONE
    }





}
