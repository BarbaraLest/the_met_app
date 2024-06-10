package com.example.themetapp.viewmodels.factorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.viewmodels.ObjectViewModel

class ObjectViewModelFactory(private val datasource: MetMuseumRemoteDatasource) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ObjectViewModel::class.java)) {
            return ObjectViewModel(datasource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}