package com.nexxlabs.lynq.data.remote

import com.nexxlabs.lynq.core.ApiResponse
import com.nexxlabs.lynq.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/lists/{list_id}/items")
    suspend fun getListItems(@Path("list_id") listId: String):
            Response<ApiResponse<Data>>

}
