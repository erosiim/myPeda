package com.doubleaa.ourpeda


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_host.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class hostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)


        btnRegistrarHost.setOnClickListener {
            Toast.makeText(this,"Bienvenido HOST", Toast.LENGTH_LONG).show()
            val intent = Intent (this, HostMain::class.java)
            startActivity(intent)

           /* val usuarioHost = txtNombreUsuario.toString().trim()
            val nombreHost = txtNombreHost.toString().trim()
            val apellidoHost = txtApellidosHost.toString().trim()
            val passwordHost = txtPassword.toString().trim()
            val edadHost = txtEdad.toString().trim()
            val telefonoHost = txtTelefono.toString().trim()
            val direccionHost = txtDireccion.toString().trim()

            if(nombreHost.isEmpty()){
                txtNombreHost.error = "Dato importante!"
                txtNombreHost.requestFocus()
                return@setOnClickListener
            }

            if(usuarioHost.isEmpty()){
                txtNombreUsuario.error = "Dato importante!"
                txtNombreHost.requestFocus()
                return@setOnClickListener
            }

            if(passwordHost.isEmpty()){
                txtPassword.error = "Dato importante!"
                txtPassword.requestFocus()
                return@setOnClickListener
            }
            if(edadHost.isEmpty()){
                txtEdad.error = "Dato importante!"
                txtEdad.requestFocus()
                return@setOnClickListener
            }


            Toast.makeText(this,"ingresa", Toast.LENGTH_LONG).show()

            RetrofitClient.instance.createHost(
                nombreHost,apellidoHost,usuarioHost,passwordHost,edadHost.toInt(),telefonoHost,direccionHost
            ).enqueue(object: Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                }

            })
            Toast.makeText(this,"bla", Toast.LENGTH_LONG).show()
        }*/




    }

    }

}
