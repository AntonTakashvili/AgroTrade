package com.example.agrotrade.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ResClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    fun initClients(){
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()




    }

    private fun <S> getService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    val getReqResApi: ResReqApi
        get() = getService(ResReqApi::class.java)
}
