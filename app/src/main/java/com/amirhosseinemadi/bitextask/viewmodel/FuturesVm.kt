package com.amirhosseinemadi.bitextask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import com.amirhosseinemadi.bitextask.model.remote.RemoteDao
import com.amirhosseinemadi.bitextask.model.remote.RemoteRepository
import com.amirhosseinemadi.bitextask.model.remote.RetrofitProvider
import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import com.amirhosseinemadi.bitextask.model.remote.entity.RespObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FuturesVm : ViewModel() {

    val remoteRepository:RemoteRepository
    var orderLiveData:MutableLiveData<RespObject<Order>>

    init
    {
        remoteRepository = RemoteRepository(RetrofitProvider.retrofit.create(RemoteDao::class.java))
        orderLiveData = MutableLiveData()
    }


    fun createOrder(token:String, amount:Double)
    {
        orderLiveData.postValue(RespObject())

        CoroutineScope(Dispatchers.IO).launch {

                val respObject:RespObject<Order> =  remoteRepository.createOrder(token, amount)
                orderLiveData.postValue(respObject)

            }
    }

}