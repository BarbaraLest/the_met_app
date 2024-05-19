package com.example.themetapp.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/public/collection/v1/objects/1")
    fun getObjectById() : Call<ResponseBody>
}