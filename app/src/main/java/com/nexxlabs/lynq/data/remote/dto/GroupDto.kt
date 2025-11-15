package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("group_id") val groupId: String,
    @SerializedName("group_name") val groupName: String,
    val description: String? = null,
    @SerializedName("created_by") val createdBy: String,
    @SerializedName("created_at") val createdAt: String
)
