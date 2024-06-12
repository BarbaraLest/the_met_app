package com.example.themetapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.models.DepartmentObjectsIdsModel
import com.example.themetapp.models.ObjectModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resumeWithException

class DepartmentViewModel(private val datasource: MetMuseumRemoteDatasource) : ViewModel() {
    private val _departmentObjects = MutableLiveData<List<ObjectModel>>()
    val departmentObjects: LiveData<List<ObjectModel>> get() = _departmentObjects

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getDepartmentObjectsIds(id: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            try {
                val departmentObjectsIds = withContext(Dispatchers.IO) {
                    getDepartmentObjectsIdsAsync(id)
                }
                val objects = withContext(Dispatchers.IO) {
                    getObjectsByIds(departmentObjectsIds.objectIDs)
                }

                _departmentObjects.postValue(objects)

            } catch (e: Exception) {
                _error.postValue(e.message)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    private suspend fun getDepartmentObjectsIdsAsync(id: Int): DepartmentObjectsIdsModel {
        return suspendCancellableCoroutine { continuation ->
            datasource.getDepartmentObjectsIds(id) { item, throwable ->
                if (item != null) {
                    continuation.resume(item, null)
                } else if (throwable != null) {
                    continuation.resumeWithException(throwable)
                }
            }
        }
    }

    private suspend fun getObjectsByIds(ids: List<Int>): List<ObjectModel> {
        val objects = mutableListOf<ObjectModel>()

       val test = ids.subList(0, 15)

        for (id in test) {
            try {
                val obj = withContext(Dispatchers.IO) {
                    getObjectByIdAsync(id)
                }
                obj?.let { objects.add(it) }
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }

        return objects
    }

    private suspend fun getObjectByIdAsync(id: Int): ObjectModel? {
        return suspendCancellableCoroutine { continuation ->
            datasource.getObjectById(id) { item, throwable ->
                if (item != null) {
                    continuation.resume(item, null)
                } else if (throwable != null) {
                    continuation.resumeWithException(throwable)
                }
            }
        }
    }


}