package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class InviteDto(
    @SerializedName("invite_id") val inviteId: String,
    @SerializedName("group_id") val groupId: String,
    @SerializedName("invited_by") val invitedBy: String,
    @SerializedName("invited_user_id") val invitedUserId: String? = null,
    @SerializedName("invited_email") val invitedEmail: String? = null,
    val status: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("expires_at") val expiresAt: String? = null
)
