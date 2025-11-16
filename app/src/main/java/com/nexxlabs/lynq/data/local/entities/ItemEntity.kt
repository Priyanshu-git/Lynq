package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey @ColumnInfo(name = "item_id")
    val itemId: String,

    @ColumnInfo(name = "list_id")
    val listId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false,

    @ColumnInfo(name = "assignee_id")
    val assigneeId: String? = null,

    @ColumnInfo(name = "created_by")
    val createdBy: String,

    @ColumnInfo(name = "priority")
    val priority: Int = 0,

    @ColumnInfo(name = "due_date")
    val dueDate: Long? = null,

    // attributes stored as JSON string
    @ColumnInfo(name = "attributes_json")
    val attributesJson: String? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: Long,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long,

    @ColumnInfo(name = "sync_status")
    val syncStatus: Int = 0 // 0=synced,1=pending,2=failed
)
