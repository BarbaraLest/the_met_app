package com.example.themetapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.HomeViewModel
import com.example.themetapp.viewmodels.factorys.HomeViewModelFactory
import com.example.themetapp.views.adapters.HomeAdapter

class HomePage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(datasource)
    }

    private lateinit var progressDialog: AlertDialog
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)



        recyclerView = findViewById(R.id.recyclerViewDepartments)
        recyclerView.layoutManager = LinearLayoutManager(this)


        progressDialog = AlertDialog.Builder(this).apply {
            setView(layoutInflater.inflate(R.layout.dialog_loading, null))
            setCancelable(false)
        }.create()

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                progressDialog.show()
            } else {
                progressDialog.dismiss()
            }
        }

        viewModel.departments.observe(this) { departments ->
            recyclerView.adapter = HomeAdapter(this, departments.departments)
        }

        viewModel.loadDepartments()


    }
}