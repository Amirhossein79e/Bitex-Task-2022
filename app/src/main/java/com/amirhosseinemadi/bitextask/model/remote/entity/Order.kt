package com.amirhosseinemadi.bitextask.model.remote.entity

import com.google.gson.annotations.SerializedName

class Order {

    @SerializedName("id")
    var id:Int? = null

    @SerializedName("token")
    var token:String? = null

    @SerializedName("amount")
    var amount:Long? = null

    @SerializedName("created_at")
    var createdAt:String? = null

}