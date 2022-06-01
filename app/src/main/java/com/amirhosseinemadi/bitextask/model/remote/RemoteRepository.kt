package com.amirhosseinemadi.bitextask.model.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import com.amirhosseinemadi.bitextask.model.remote.entity.RespMapper
import com.amirhosseinemadi.bitextask.model.remote.entity.RespObject
import kotlinx.coroutines.*

class RemoteRepository(private val remoteDao: RemoteDao) {

    fun createOrder(token:String, amount:Double) : LiveData<RespObject<Order>>
    {
        return liveData(Dispatchers.IO)
        {
            emit(RespObject())
            emit(RespMapper.map(remoteDao.createOrder(token,amount)))
        }
    }

}