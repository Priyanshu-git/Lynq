package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ListDto(
    @SerializedName("list_id") val listId: String,
    val title: String,
    val description: String? = null,
    @SerializedName("list_type") val listType: String,
    @SerializedName("created_by") val createdBy: String,
    @SerializedName("group_id") val groupId: String? = null,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)
