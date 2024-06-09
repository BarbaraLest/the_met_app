package com.example.themetapp.datasources

import com.example.themetapp.models.DepartmentObjectsIdsModel
import com.example.themetapp.models.DepartmentsModel
import com.example.themetapp.models.ObjectModel
import com.example.themetapp.network.ApiService
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetMuseumRemoteDatasource(private val apiService: ApiService) {
    fun getObjectById(id: Int, onResponse: (ObjectModel?, Throwable?) -> Unit) {
        apiService.getObjectById(id).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val result: String? = response.body()?.string()
                    val formattedResult = Gson().fromJson(result, ObjectModel::class.java)
                    onResponse(formattedResult, null)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, response: Throwable) {
                onResponse(null, response)
            }
        })
    }


    fun getDepartments(onResponse: (DepartmentsModel?, Throwable?) -> Unit) {
        apiService.getDepartments().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val result: String? = response.body()?.string()
                    val formattedResult = Gson().fromJson(result, DepartmentsModel::class.java)
                    onResponse(formattedResult, null)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, response: Throwable) {
                onResponse(null, response)
            }
        })
    }


    fun getDepartmentObjectsIds(
        id: Int,
        onResponse: (DepartmentObjectsIdsModel?, Throwable?) -> Unit
    ) {
        apiService.getDepartmentObjectsIds(id).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val result: String? = response.body()?.string()
                    val formattedResult =
                        Gson().fromJson(result, DepartmentObjectsIdsModel::class.java)
                    onResponse(formattedResult, null)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, response: Throwable) {
                onResponse(null, response)
            }
        })
    }
}