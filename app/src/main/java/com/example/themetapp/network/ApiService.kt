package com.example.themetapp.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/public/collection/v1/objects/{id}")
    fun getObjectById(@Path("id") id: Int): Call<ResponseBody>


    @GET("/public/collection/v1/departments")
    fun getDepartments(): Call<ResponseBody>


    @GET("/public/collection/v1/objects")
    fun getDepartmentObjectsIds(@Query(value = "departmentIds") departmentId: Int): Call<ResponseBody>


}