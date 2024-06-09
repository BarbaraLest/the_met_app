package com.example.themetapp.models


data class DepartmentsModel(
    val departments: List<Department>
)

data class Department(
    val departmentId: Int,
    val displayName: String
)
