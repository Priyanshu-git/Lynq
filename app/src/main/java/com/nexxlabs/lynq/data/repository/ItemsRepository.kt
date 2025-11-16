package com.nexxlabs.lynq.data.repository

import com.nexxlabs.lynq.core.NetworkResult
import com.nexxlabs.lynq.core.UIState
import com.nexxlabs.lynq.data.remote.ApiService
import com.nexxlabs.lynq.data.remote.RetrofitClient.api
import com.nexxlabs.lynq.data.remote.dto.ItemDto
import com.nexxlabs.lynq.data.remote.requests.CreateItemRequest
import com.nexxlabs.lynq.data.remote.requests.UpdateItemRequest
import com.nexxlabs.lynq.data.remote.safeApiCall
import javax.inject.Inject


/**
 * Items repository using:
 *  safeApiCall -> NetworkResult<T>
 *  mapped -> UIState<T> (for clean ViewModel usage)
 */
class ItemsRepository @Inject constructor(private val api: ApiService) {

    suspend fun fetchItems(listId: String): UIState<List<ItemDto>> {
        return when (val nr = safeApiCall { api.getListItems(listId) }) {
            is NetworkResult.Success ->
                UIState.Success(nr.data)

            is NetworkResult.Failure ->
                UIState.Error("Server error: ${nr.message ?: "Unknown"}")

            is NetworkResult.Exception ->
                UIState.Error("Network error: ${nr.exception.message ?: "Unknown"}")
        }
    }

    suspend fun createItem(listId: String, req: CreateItemRequest): UIState<ItemDto> {
        return when (val nr = safeApiCall { api.createItem(listId, req) }) {
            is NetworkResult.Success ->
                UIState.Success(nr.data)

            is NetworkResult.Failure ->
                UIState.Error("Server error: ${nr.message ?: "Unknown"}")

            is NetworkResult.Exception ->
                UIState.Error("Network error: ${nr.exception.message ?: "Unknown"}")
        }
    }

    suspend fun updateItem(itemId: String, req: UpdateItemRequest): UIState<ItemDto> {
        return when (val nr = safeApiCall { api.updateItem(itemId, req) }) {
            is NetworkResult.Success ->
                UIState.Success(nr.data)

            is NetworkResult.Failure ->
                UIState.Error("Server error: ${nr.message ?: "Unknown"}")

            is NetworkResult.Exception ->
                UIState.Error("Network error: ${nr.exception.message ?: "Unknown"}")
        }
    }

    suspend fun deleteItem(itemId: String): UIState<Unit> {
        return when (val nr = safeApiCall { api.deleteItem(itemId) }) {
            is NetworkResult.Success ->
                UIState.Success(Unit)

            is NetworkResult.Failure ->
                UIState.Error("Server error: ${nr.message ?: "Unknown"}")

            is NetworkResult.Exception ->
                UIState.Error("Network error: ${nr.exception.message ?: "Unknown"}")
        }
    }
}