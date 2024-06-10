package com.example.themetapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.ObjectViewModel
import com.example.themetapp.viewmodels.factorys.ObjectViewModelFactory

class ObjectPage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private lateinit var viewModel: ObjectViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`object`)


        val objectId = intent.getStringExtra("objectId") ?: 1


        viewModel = ViewModelProvider(
            this,
            ObjectViewModelFactory(datasource)
        )[ObjectViewModel::class.java]

        viewModel.getObjectById(objectId as Int)


    }
}