package com.amirhosseinemadi.bitextask.model.remote

import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import com.amirhosseinemadi.bitextask.model.remote.entity.RespMapper
import com.amirhosseinemadi.bitextask.model.remote.entity.RespObject

class RemoteRepository(private val remoteDao: RemoteDao) {

    suspend fun createOrder(token:String, amount:Double) : RespObject<Order>
    {
       return RespMapper.map(remoteDao.createOrder(token,amount))
    }

}