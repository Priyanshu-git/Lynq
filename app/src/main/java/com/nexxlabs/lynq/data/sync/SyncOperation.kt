package com.nexxlabs.lynq.data.sync

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sync_operations")
data class SyncOperation(
    @PrimaryKey @ColumnInfo(name = "op_id")
    val opId: String,

    @ColumnInfo(name = "entity")
    val entity: String, // e.g., "item"

    @ColumnInfo(name = "action")
    val action: String, // create/update/delete

    @ColumnInfo(name = "entity_client_id")
    val entityClientId: String? = null,

    @ColumnInfo(name = "entity_server_id")
    val entityServerId: String? = null,

    @ColumnInfo(name = "payload_json")
    val payloadJson: String,

    @ColumnInfo(name = "client_ts")
    val clientTimestamp: Long,

    @ColumnInfo(name = "status")
    val status: String = "pending", // pending/sent/failed

    @ColumnInfo(name = "attempts")
    val attempts: Int = 0
)
