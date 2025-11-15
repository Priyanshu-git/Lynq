package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class CreateGroupRequest(
    @SerializedName("group_name") val groupName: String,
    val description: String? = null
)
