package com.nexxlabs.lynq.data.repository

import com.nexxlabs.lynq.data.remote.ApiService
import com.nexxlabs.lynq.core.NetworkResult
import com.nexxlabs.lynq.data.remote.RetrofitClient
import com.nexxlabs.lynq.data.remote.safeApiCall
import com.nexxlabs.lynq.model.Data


class ItemsRepository(
    private val api: ApiService = RetrofitClient.api
) {

    suspend fun fetchItems(listId: String): NetworkResult<Data> {
        return safeApiCall { api.getListItems(listId) }
    }


}