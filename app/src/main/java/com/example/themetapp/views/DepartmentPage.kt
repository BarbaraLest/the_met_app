package com.example.themetapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.DepartmentViewModel
import com.example.themetapp.viewmodels.factorys.DepartmentViewModelFactory
import com.example.themetapp.views.adapters.DepartmentsAdapter

class DepartmentPage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private val viewModel: DepartmentViewModel by viewModels {
        DepartmentViewModelFactory(datasource)
    }

    private lateinit var progressDialog: AlertDialog
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.departments_page)

        val departmentId = intent.getStringExtra("departmentId")


        recyclerView = findViewById(R.id.recyclerViewObjects)
        recyclerView.layoutManager = LinearLayoutManager(this)

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

        viewModel.departmentObjects.observe(this, Observer { departmentObjects ->
            recyclerView.adapter = DepartmentsAdapter(this, departmentObjects)
        })

        viewModel.getDepartmentObjectsIds(departmentId!!.toInt())


    }
}