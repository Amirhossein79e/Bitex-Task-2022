package com.amirhosseinemadi.bitextask

import okhttp3.*

class MockInterceptor : Interceptor {

    var mockResponse:String = ""
    var responseCode:Int = 404

    override fun intercept(chain: Interceptor.Chain): Response {

        return Response.Builder()
            .protocol(Protocol.HTTP_1_1)
            .request(chain.request())
            .header("Content-Type","application/json")
            .code(responseCode)
            .message("SUCCESSFUL")
            .body(ResponseBody.create(MediaType.get("application/json"),mockResponse))
            .build()
    }

}