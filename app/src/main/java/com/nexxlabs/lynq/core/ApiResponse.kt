package com.nexxlabs.lynq.core

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?
)