package com.doubleaa.ourpeda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.doubleaa.ourpeda.APIInterfaceRequest.IHostApiService
import com.doubleaa.ourpeda.HttpBodyPojos.HostBodyPojo
import com.doubleaa.ourpeda.HttpBodyPojos.InvitadoBodyPojo
import kotlinx.android.synthetic.main.activity_host.*
import kotlinx.android.synthetic.main.activity_invited.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class invitedActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder().addCallAdapterFactory(
        RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://mipeda.appspot.com/")
        .build();

    var retrofitobj = retrofit.create(IHostApiService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invited)

        btnRegistroInvitadosR.setOnClickListener {
            insertOne()
            Toast.makeText(this,"Éxito",Toast.LENGTH_LONG).show()
            val intent = Intent (this, InvitadoMain::class.java)
            startActivity(intent)
        }

    }


    fun insertOne(){
        //INICIA POST
        var newInvitado = InvitadoBodyPojo()
        newInvitado.nombre = txtNombreInvitadoR.text.toString()+txtApellidosInvitadoR.text.toString()
        newInvitado.usuario = txtNombreUsuarioInvitadoR.text.toString()
        newInvitado.edad = txtEdadInvitadoR.text.toString()
        newInvitado.contrasena = txtPasswordInvitadoR.text.toString()
        newInvitado.telefono = txtTelefonoInvitadoR.text.toString()

        retrofitobj.createInvitado(newInvitado).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    var t = Toast.makeText(this@invitedActivity, "ERROR ADDING", Toast.LENGTH_LONG)

                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@invitedActivity, "ADDED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }

            }

        )

        // TERMINA POST
    }


}
