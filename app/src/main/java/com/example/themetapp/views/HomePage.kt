package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.HomeViewModel
import com.example.themetapp.viewmodels.factorys.HomeViewModelFactory

class HomePage : AppCompatActivity() {
    private val datasource = MetMuseumRemoteDatasource(ApiService.apiService)
    private lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(datasource)
        )[HomeViewModel::class.java]

        viewModel.getDepartments()


//        btn.setOnClickListener {
//            val intent = Intent(
//                this@HomePage, DepartmentPage::class.java
//            ).apply {
//                putExtra("departmentId", 1)
//            }
//            startActivity(intent)
//        }
    }
}