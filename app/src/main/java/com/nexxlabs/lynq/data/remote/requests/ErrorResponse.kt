package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error_code") val errorCode: String?,
    val message: String?,
    val details: Map<String, Any?>? = null
)
