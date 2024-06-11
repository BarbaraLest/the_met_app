package com.example.themetapp.models


data class DepartmentsModel(
    val departments: List<DepartmentModel>
)

data class DepartmentModel(
    val departmentId: Int,
    val displayName: String
)
