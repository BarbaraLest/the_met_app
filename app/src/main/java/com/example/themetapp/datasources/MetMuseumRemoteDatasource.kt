package com.example.themetapp.datasources

import com.example.themetapp.models.ObjectModel
import com.example.themetapp.network.ApiService
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetMuseumRemoteDatasource(private val apiService: ApiService) {
    fun getObjectById(onResponse: (ObjectModel?, Throwable?) -> Unit){
        apiService.getObjectById().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    val result: String? = response.body()?.string()
                    val formattedResult =  Gson().fromJson(result, ObjectModel::class.java)
                    onResponse(formattedResult, null)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, response: Throwable) {
                onResponse(null, response)
            }
        })
    }
}