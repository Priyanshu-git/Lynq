package com.nexxlabs.lynq.model.domain

data class ItemModel(
    val id: String,
    val listId: String,
    val title: String,
    val isCompleted: Boolean = false,
    val assigneeId: String? = null,
    val createdBy: String,
    val priority: Int = 0, // 0=low,1=medium,2=high
    val dueDate: String? = null,
    val attributes: Map<String, Any>? = null, // quantity, unit, price, custom metadata
    val createdAt: String,
    val updatedAt: String,
    val assignment: AssignmentSummary? = null
)
