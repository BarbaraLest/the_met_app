package com.example.themetapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentObjectsIdsModel

class DepartmentViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {
    var departmentObjectsIds: DepartmentObjectsIdsModel? = null
    var getDepartmentObjectsIdsError: Throwable? = null


    fun getDepartmentObjectsIds(id: Int) {
        datasource.getDepartmentObjectsIds(id) { item, error ->
            if (item != null) {
                departmentObjectsIds = item
            }

            if (error != null) {
                getDepartmentObjectsIdsError = error
            }
        }
    }

}