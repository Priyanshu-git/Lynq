package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invites")
data class InviteEntity(
    @PrimaryKey @ColumnInfo(name = "invite_id")
    val inviteId: String,

    @ColumnInfo(name = "group_id")
    val groupId: String,

    @ColumnInfo(name = "invited_email")
    val invitedEmail: String? = null,

    @ColumnInfo(name = "invited_user_id")
    val invitedUserId: String? = null,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "created_at")
    val createdAt: Long
)
