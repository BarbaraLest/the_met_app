package com.example.themetapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.HomeViewModel
import com.example.themetapp.viewmodels.ObjectViewModel
import com.example.themetapp.viewmodels.factorys.HomeViewModelFactory
import com.example.themetapp.viewmodels.factorys.ObjectViewModelFactory

class ObjectPage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private val viewModel: ObjectViewModel by viewModels {
        ObjectViewModelFactory(datasource)
    }

    private lateinit var progressDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`object`)

        val objectId = intent.getStringExtra("objectId") ?: 1

        progressDialog = AlertDialog.Builder(this).apply {
            setView(layoutInflater.inflate(R.layout.dialog_loading, null))
            setCancelable(false)
        }.create()


        viewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) {
                progressDialog.show()
            } else {
                progressDialog.dismiss()
            }
        })

        viewModel.getObjectById(objectId as Int)




    }
}