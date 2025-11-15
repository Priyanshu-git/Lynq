package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("item_id") val itemId: String,
    @SerializedName("list_id") val listId: String,
    val title: String,
    @SerializedName("is_completed") val isCompleted: Boolean = false,
    @SerializedName("due_date") val dueDate: String? = null,
    val priority: Int = 0,
    @SerializedName("created_by") val createdBy: String,
    @SerializedName("assignee_id") val assigneeId: String? = null,
    val attributes: Map<String, Any?>? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null
)
