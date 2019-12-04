package com.doubleaa.ourpeda

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("crearHost")
    fun createHost(@Body host : Hosts):Call<DefaultResponse>

        /*@Field("nombre") nombre:String,
        @Field("apellido") apellido:String,
        @Field("usuario") usuario:String,
        @Field("contrasena") contrasena:String,
        @Field("edad") edad:Int,
        @Field("telefono") telefono:String,
        @Field("direccion") direccion:String
    ):*/
}