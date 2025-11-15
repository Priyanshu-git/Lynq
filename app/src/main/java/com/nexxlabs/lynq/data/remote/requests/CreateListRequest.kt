package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class CreateListRequest(
    val title: String,
    val description: String? = null,
    @SerializedName("list_type") val listType: String,
    @SerializedName("group_id") val groupId: String? = null
)
