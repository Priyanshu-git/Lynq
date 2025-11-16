package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lists")
data class ListEntity(
    @PrimaryKey @ColumnInfo(name = "list_id")
    val listId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "list_type")
    val listType: String,

    @ColumnInfo(name = "created_by")
    val createdBy: String,

    @ColumnInfo(name = "group_id")
    val groupId: String? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: Long,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long
)
