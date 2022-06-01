package com.amirhosseinemadi.bitextask.model.remote.entity

import com.amirhosseinemadi.bitextask.util.RespStatus

class RespObject<T> {

    var respStatus: RespStatus = RespStatus.LOADING
    var response:T? = null

}