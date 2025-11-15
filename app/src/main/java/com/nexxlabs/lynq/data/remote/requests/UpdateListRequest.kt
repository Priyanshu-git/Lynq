package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class UpdateListRequest(
    val title: String? = null,
    val description: String? = null,
    @SerializedName("list_type") val listType: String? = null
)
