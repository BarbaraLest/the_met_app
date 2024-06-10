package com.example.themetapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentsModel

class HomeViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {

    var departmentsModel: DepartmentsModel? = null
    var getDepartmentsError: Throwable? = null

    fun getDepartments() {
        datasource.getDepartments { item, error ->
            if (item != null) {
                departmentsModel = item
            }

            if (error != null) {
                getDepartmentsError = error
            }

        }

    }
}