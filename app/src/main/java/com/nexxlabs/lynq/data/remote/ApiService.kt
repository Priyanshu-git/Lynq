package com.nexxlabs.lynq.data.remote

import com.nexxlabs.lynq.core.ApiResponse
import com.nexxlabs.lynq.data.remote.dto.AuthResponseDto
import com.nexxlabs.lynq.data.remote.dto.GroupDto
import com.nexxlabs.lynq.data.remote.dto.ItemDto
import com.nexxlabs.lynq.data.remote.dto.ListDto
import com.nexxlabs.lynq.data.remote.requests.CreateGroupRequest
import com.nexxlabs.lynq.data.remote.requests.CreateItemRequest
import com.nexxlabs.lynq.data.remote.requests.CreateListRequest
import com.nexxlabs.lynq.data.remote.requests.UpdateItemRequest
import com.nexxlabs.lynq.data.remote.requests.UpdateListRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Lists
    @GET("v1/lists")
    suspend fun getLists(): Response<ApiResponse<List<ListDto>>>

    @GET("v1/lists/{list_id}")
    suspend fun getList(@Path("list_id") listId: String): Response<ApiResponse<ListDto>>

    @POST("v1/lists")
    suspend fun createList(@Body req: CreateListRequest): Response<ApiResponse<ListDto>>

    @PATCH("v1/lists/{list_id}")
    suspend fun updateList(@Path("list_id") listId: String, @Body req: UpdateListRequest): Response<ApiResponse<ListDto>>

    @DELETE("v1/lists/{list_id}")
    suspend fun deleteList(@Path("list_id") listId: String): Response<ApiResponse<Unit>>

    // Items (tasks)
    @GET("v1/lists/{list_id}/items")
    suspend fun getListItems(@Path("list_id") listId: String): Response<ApiResponse<List<ItemDto>>>

    @POST("v1/lists/{list_id}/items")
    suspend fun createItem(@Path("list_id") listId: String, @Body req: CreateItemRequest): Response<ApiResponse<ItemDto>>

    @PATCH("v1/items/{item_id}")
    suspend fun updateItem(@Path("item_id") itemId: String, @Body req: UpdateItemRequest): Response<ApiResponse<ItemDto>>

    @DELETE("v1/items/{item_id}")
    suspend fun deleteItem(@Path("item_id") itemId: String): Response<ApiResponse<Unit>>

    // Auth
    @POST("v1/auth/google")
    suspend fun authWithGoogle(@Body body: Map<String, String>): Response<ApiResponse<AuthResponseDto>>

    // Groups (minimal)
    @POST("v1/groups")
    suspend fun createGroup(@Body req: CreateGroupRequest): Response<ApiResponse<GroupDto>>

    @GET("v1/groups")
    suspend fun getMyGroups(): Response<ApiResponse<List<GroupDto>>>

    // Sync endpoints (server-driven): optional later
    @POST("v1/sync/operations")
    suspend fun pushOperations(@Body payload: Map<String, Any>): Response<ApiResponse<Unit>>

    @GET("v1/sync/changes")
    suspend fun getChanges(@Query("since") since: String): Response<ApiResponse<List<Any>>>
}
