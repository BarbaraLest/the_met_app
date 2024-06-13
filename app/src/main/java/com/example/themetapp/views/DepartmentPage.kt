package com.example.themetapp.views

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentModel
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


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.departments_page)

        val departmentModel  =  intent.getParcelableExtra<DepartmentModel>("departmentModel")


        recyclerView = findViewById(R.id.recyclerViewObjects)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val departmentTitle : TextView = findViewById(R.id.title)

        departmentTitle.text = departmentModel!!.displayName

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

        viewModel.departmentObjects.observe(this) { departmentObjects ->
            recyclerView.adapter = DepartmentsAdapter(this, departmentObjects)
        }

        viewModel.getDepartmentObjectsIds(departmentModel!!.departmentId)


    }
}