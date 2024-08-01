package com.example.tipoprueba.retrofit

import com.example.tipoprueba.interfaces.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://randomuser.me/"

    private val client= OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
                val cookies = originalResponse.headers("Set-Cookie")
                println("Cookies: $cookies")
            }
            originalResponse
        }
        .build()

    val instance: ApiService by lazy{
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

}