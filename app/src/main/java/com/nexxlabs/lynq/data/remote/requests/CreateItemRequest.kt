package com.nexxlabs.lynq.data.remote.requests

import com.google.gson.annotations.SerializedName

data class CreateItemRequest(
    val title: String,
    val attributes: Map<String, Any?>? = null,
    @SerializedName("due_date") val dueDate: String? = null,
    val priority: Int? = null,
    @SerializedName("assignee_id") val assigneeId: String? = null
)
