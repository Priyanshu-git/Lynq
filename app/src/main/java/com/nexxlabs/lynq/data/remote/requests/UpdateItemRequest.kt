package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class UpdateItemRequest(
    val title: String? = null,
    @SerializedName("is_completed") val isCompleted: Boolean? = null,
    val attributes: Map<String, Any?>? = null,
    @SerializedName("assignee_id") val assigneeId: String? = null,
    @SerializedName("due_date") val dueDate: String? = null,
    val priority: Int? = null
)
