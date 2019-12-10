package com.doubleaa.ourpeda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.doubleaa.ourpeda.APIInterfaceRequest.IHostApiService
import com.doubleaa.ourpeda.HttpBodyPojos.PedaBody
import kotlinx.android.synthetic.main.activity_host.*
import kotlinx.android.synthetic.main.activity_host_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HostMain : AppCompatActivity() {

    val retrofit = Retrofit.Builder().addCallAdapterFactory(
        RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://mipeda.appspot.com/")
        .build();

    var retrofitobj = retrofit.create(IHostApiService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_main)

    btnCrearDrink.setOnClickListener {
        insertOne()

        Toast.makeText(this,"Drink guardado!", Toast.LENGTH_LONG).show()
    }


    }


    fun insertOne(){
        //INICIA POST
        var newPeda = PedaBody()
        newPeda.id = 0
        newPeda.cantidad = txtCantidadDrink.text.toString()
        newPeda.horario = txtHorarioDrink.text.toString()
        newPeda.presupuesto = txtPresupuetoDrink.text.toString()

        retrofitobj.createPeda(newPeda).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@HostMain, "ERROR ADDING", Toast.LENGTH_LONG)
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@HostMain, "ADDED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }

            }

        )

        // TERMINA POST
    }





}
