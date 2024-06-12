package com.example.themetapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentsModel
import com.example.themetapp.models.ObjectModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ObjectViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {
    private val _objectModel = MutableLiveData<ObjectModel>()
    val objectModel: LiveData<ObjectModel> get() = _objectModel

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getObjectById(id: Int) {
        _isLoading.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                datasource.getObjectById(id) { item, throwable ->
                    _isLoading.postValue(false)

                    if (item != null) {
                        _objectModel.postValue(item!!)
                    } else if (throwable != null) {
                        _error.postValue(throwable.message)
                    }
                }
            }
        }
    }


}