package com.example.themetapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.ObjectModel

class ObjectViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {
    var objectModel: ObjectModel? = null
    var getObjectByIdError: Throwable? = null


    fun getObjectById(id: Int) {
        datasource.getObjectById(id) { item, error ->
            if (item != null) {
                objectModel = item
            }

            if (error != null) {
                getObjectByIdError = error
            }
        }
    }

}