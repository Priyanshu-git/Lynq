package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_members")
data class GroupMemberEntity(
    @PrimaryKey @ColumnInfo(name = "group_member_id")
    val groupMemberId: String,

    @ColumnInfo(name = "group_id")
    val groupId: String,

    @ColumnInfo(name = "user_id")
    val userId: String,

    @ColumnInfo(name = "role")
    val role: String = "member",

    @ColumnInfo(name = "joined_at")
    val joinedAt: Long
)
