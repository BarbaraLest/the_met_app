package com.example.themetapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentObjectsIdsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DepartmentViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {
    private val _departmentObjectsIds = MutableLiveData<DepartmentObjectsIdsModel>()
    val departmentObjectsIds: LiveData<DepartmentObjectsIdsModel> get() = _departmentObjectsIds

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun getDepartmentObjectsIds(id: Int) {
        _isLoading.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                datasource.getDepartmentObjectsIds(id) { item, throwable ->
                    _isLoading.postValue(false)

                    if (item != null) {
                        _departmentObjectsIds.postValue(item!!)
                    } else if (throwable != null) {
                        _error.postValue(throwable.message)
                    }
                }
            }
        }

    }
}