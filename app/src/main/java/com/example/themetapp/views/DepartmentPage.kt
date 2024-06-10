package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.DepartmentViewModel
import com.example.themetapp.viewmodels.factorys.ObjectViewModelFactory

class DepartmentPage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private lateinit var viewModel: DepartmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.departments)

        val departmentId = intent.getStringExtra("departmentId") ?: 1

        viewModel = ViewModelProvider(
            this,
            ObjectViewModelFactory(datasource)
        )[DepartmentViewModel::class.java]

        viewModel.getDepartmentObjectsIds(departmentId as Int)


//        btn.setOnClickListener {
//            val intent = Intent(
//                this@DepartmentPage, ObjectPage::class.java
//            ).apply {
//                putExtra("objectId", 2)
//            }
//            startActivity(intent)
//        }

    }
}