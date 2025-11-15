package com.nexxlabs.lynq.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GroupMemberDto(
    @SerializedName("group_member_id") val groupMemberId: String,
    @SerializedName("group_id") val groupId: String,
    @SerializedName("user_id") val userId: String,
    val role: String,
    @SerializedName("joined_at") val joinedAt: String
)
