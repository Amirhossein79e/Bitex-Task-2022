package com.amirhosseinemadi.bitextask

import com.amirhosseinemadi.bitextask.model.remote.RemoteDao
import com.amirhosseinemadi.bitextask.model.remote.RetrofitProvider
import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import com.amirhosseinemadi.bitextask.model.remote.entity.RespMapper
import com.amirhosseinemadi.bitextask.model.remote.entity.RespObject
import com.amirhosseinemadi.bitextask.util.RespStatus
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class UnitTest {

    private lateinit var retrofit:Retrofit
    private lateinit var remoteDao: RemoteDao
    private lateinit var mockInterceptor:MockInterceptor

    @Before
    fun init()
    {
        mockInterceptor = MockInterceptor()

        val client:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .build()

        retrofit = RetrofitProvider.retrofit
        val mockRetrofit:Retrofit = retrofit.newBuilder().client(client).build()
        remoteDao = mockRetrofit.create(RemoteDao::class.java)
    }


    @Test
    fun orderApi()
    {
        mockInterceptor.responseCode = 200
        mockInterceptor.mockResponse = "{\"amount\": 41.0,\"token\": \"token 57\",\"created_at\": \"2038-12-01T08:42:52.315Z\",\"id\": 57}"

        runBlocking {

            assertEquals(57,remoteDao.createOrder("BTC",1.0).body()?.id)

        }
    }


    @Test
    fun mapper()
    {
        mockInterceptor.responseCode = 200
        mockInterceptor.mockResponse = "{\"amount\": 41.0,\"token\": \"token 57\",\"created_at\": \"2038-12-01T08:42:52.315Z\",\"id\": 57}"

        runBlocking {

            val mappedData:RespObject<Order> = RespMapper.map(remoteDao.createOrder("BTC",1.0))
            assertEquals(RespStatus.SUCCESSFUL,mappedData.respStatus)
            assertEquals("token 57",mappedData.response?.token)

        }
    }

}