package com.doubleaa.ourpeda.APIInterfaceRequest

import com.doubleaa.ourpeda.HttpBodyPojos.HostBodyPojo
import com.doubleaa.ourpeda.HttpBodyPojos.PedaBody
import com.doubleaa.ourpeda.HttpResponsePojos.HostResponse
import com.doubleaa.ourpeda.HttpResponsePojos.PedaResponse
import retrofit2.Call
import retrofit2.http.*

interface IHostApiService {

    @GET("hosts")
    fun getHosts(): Call< ArrayList<HostResponse> >

    @POST("hosts")
    fun createHost(@Body body: HostBodyPojo): Call<String>

    @GET("hosts/{id}")
    fun getHostById(@Path("id") id : String): Call<HostResponse>

    @PUT("hosts/{id}")
    fun updateHost(@Path("id") id : String, @Body body:HostBodyPojo): Call<String>

    @DELETE("hosts/{id}")
    fun deleteHost(@Path("id") id : String): Call<String>

/*----------------------------Pedas-----------------------*/

    @GET("pedas")
    fun getPedas(): Call< ArrayList<PedaResponse> >

    @POST("pedas")
    fun createPeda(@Body body: PedaBody): Call<String>

    @GET("pedas/{id}")
    fun getPedaById(@Path("id") id : String): Call<PedaResponse>

    @PUT("pedas/{id}")
    fun updatePeda(@Path("id") id : String, @Body body:PedaBody): Call<String>

    @DELETE("pedas/{id}")
    fun deletePeda(@Path("id") id : String): Call<String>

    /*--------------------------*/








}