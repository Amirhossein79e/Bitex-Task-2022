package com.amirhosseinemadi.bitextask.model.remote

import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RemoteDao {

    @POST("v1/order")
    @FormUrlEncoded
    suspend fun createOrder(@Field("token") token:String, @Field("amount") amount:Double) : Response<Order>

}