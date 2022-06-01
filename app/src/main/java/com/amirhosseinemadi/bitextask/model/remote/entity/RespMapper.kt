package com.amirhosseinemadi.bitextask.model.remote.entity

import com.amirhosseinemadi.bitextask.util.RespStatus
import retrofit2.Response

class RespMapper {

    companion object
    {
        fun<T> map(response: Response<T>) : RespObject<T>
        {
            val respObject = RespObject<T>()

            respObject.respStatus = if (response.isSuccessful) RespStatus.SUCCESSFUL else RespStatus.FAILED
            respObject.response = response.body()

            return respObject
        }
    }

}