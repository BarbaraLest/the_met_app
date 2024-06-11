package com.example.themetapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {

    private val _departments = MutableLiveData<DepartmentsModel>()
    val departments: LiveData<DepartmentsModel> get() = _departments

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadDepartments() {
        _isLoading.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                datasource.getDepartments { item, throwable ->
                    _isLoading.postValue(false)

                    if (item != null) {
                        _departments.postValue(item!!)
                    } else if (throwable != null) {
                        _error.postValue(throwable.message)
                    }
                }
            }
        }
    }
}



