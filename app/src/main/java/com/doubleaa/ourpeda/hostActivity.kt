package com.doubleaa.ourpeda


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.doubleaa.ourpeda.APIInterfaceRequest.IHostApiService
import com.doubleaa.ourpeda.HttpBodyPojos.HostBodyPojo
import com.doubleaa.ourpeda.HttpResponsePojos.HostResponse
import kotlinx.android.synthetic.main.activity_host.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class hostActivity : AppCompatActivity() {


    val retrofit = Retrofit.Builder().addCallAdapterFactory(
        RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://mipeda.appspot.com/")
        .build();

    var retrofitobj = retrofit.create(IHostApiService::class.java)





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)


        btnRegistrarHost.setOnClickListener {
            insertOne()
            Toast.makeText(this,"Bienvenido ${txtNombreUsuarioHost.text.toString()}", Toast.LENGTH_LONG).show()
            val intent = Intent (this, HostMain::class.java)
            startActivity(intent)


        }

    }

    fun insertOne(){
        //INICIA POST
        var newHost = HostBodyPojo()
        newHost.contrasena = txtPasswordHost.text.toString()
        newHost.usuario = txtNombreUsuarioHost.text.toString().trim()
        newHost.direccion = txtDireccionHost.text.toString().trim()
        newHost.edad = txtEdadHost.text.toString().trim()
        newHost.nombre = txtNombreHost.text.toString().trim()
        newHost.telefono= txtTelefonoHost.text.toString().trim()
        newHost.image = "notengo"
        retrofitobj.createHost(newHost).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@hostActivity, "ERROR ADDING", Toast.LENGTH_LONG)

                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@hostActivity, "ADDED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }

            }

        )

        // TERMINA POST
    }

    fun getTodos(){
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
                    var t = Toast.makeText(this@hostActivity, "Goood", Toast.LENGTH_LONG)
                    t.show()
                }

                override fun onFailure(call: Call<ArrayList<HostResponse>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
        )

    }

}
