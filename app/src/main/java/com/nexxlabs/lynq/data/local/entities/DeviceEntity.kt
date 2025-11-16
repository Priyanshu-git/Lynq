package com.nexxlabs.lynq.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "devices")
data class DeviceEntity(
    @PrimaryKey @ColumnInfo(name = "device_id")
    val deviceId: String,

    @ColumnInfo(name = "user_id")
    val userId: String,

    @ColumnInfo(name = "platform")
    val platform: String,

    @ColumnInfo(name = "push_token")
    val pushToken: String? = null,

    @ColumnInfo(name = "last_seen")
    val lastSeen: Long? = null
)
