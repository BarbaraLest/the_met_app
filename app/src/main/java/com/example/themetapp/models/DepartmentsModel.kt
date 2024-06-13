package com.example.themetapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class DepartmentsModel(
    val departments: List<DepartmentModel>
)

@Parcelize
data class DepartmentModel(
    val departmentId: Int,
    val displayName: String
): Parcelable
