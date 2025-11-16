package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class GroupEntity(
    @PrimaryKey @ColumnInfo(name = "group_id")
    val groupId: String,

    @ColumnInfo(name = "group_name")
    val groupName: String,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "created_by")
    val createdBy: String,

    @ColumnInfo(name = "created_at")
    val createdAt: Long
)
