package com.amirhosseinemadi.bitextask.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Kotlin singleton class
object RetrofitProvider {

    const val BASE_URL = "https://6294760fa7203b3ed06971f5.mockapi.io/api/"
    val retrofit:Retrofit

    init
    {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}