package com.doubleaa.ourpeda.APIInterfaceRequest

import com.doubleaa.ourpeda.HttpBodyPojos.HostBodyPojo
import com.doubleaa.ourpeda.HttpBodyPojos.InvitadoBodyPojo
import com.doubleaa.ourpeda.HttpBodyPojos.PedaBody
import com.doubleaa.ourpeda.HttpResponsePojos.HostResponse
import com.doubleaa.ourpeda.HttpResponsePojos.InvitadoResponse
import com.doubleaa.ourpeda.HttpResponsePojos.PedaResponse
import retrofit2.Call
import retrofit2.http.*

interface IHostApiService {

    @GET("api/hosts")
    fun getHosts(): Call< ArrayList<HostResponse> >

    @POST("api/hosts")
    fun createHost(@Body body: HostBodyPojo): Call<String>

    @GET("api/hosts/{id}")
    fun getHostById(@Path("id") id : String): Call<HostResponse>

    @PUT("api/hosts/{id}")
    fun updateHost(@Path("id") id : String, @Body body:HostBodyPojo): Call<String>

    @DELETE("api/hosts/{id}")
    fun deleteHost(@Path("id") id : String): Call<String>

/*----------------------------Pedas-----------------------*/

    @GET("api/pedas")
    fun getPedas(): Call< ArrayList<PedaResponse> >

    @POST("api/pedas")
    fun createPeda(@Body body: PedaBody): Call<String>

    @GET("api/pedas/{id}")
    fun getPedaById(@Path("id") id : String): Call<PedaResponse>

    @PUT("api/pedas/{id}")
    fun updatePeda(@Path("id") id : String, @Body body:PedaBody): Call<String>

    @DELETE("api/pedas/{id}")
    fun deletePeda(@Path("id") id : String): Call<String>

/*---------------INVITADOS--------------------------------*/
    @GET("api/usuarios")
    fun getInvitados(): Call< ArrayList<InvitadoResponse> >

    @POST("api/usuarios")
    fun createInvitado(@Body body: InvitadoBodyPojo): Call<String>

    @GET("api/usuarios/{id}")
    fun getInvitadoById(@Path("id") id : String): Call<InvitadoResponse>

    @PUT("api/usuarios/{id}")
    fun updateInvitado(@Path("id") id : String, @Body body:InvitadoBodyPojo): Call<String>

    @DELETE("api/usuarios/{id}")
    fun deleteInvitado(@Path("id") id : String): Call<String>

}