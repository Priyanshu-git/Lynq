package com.nexxlabs.lynq.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexxlabs.lynq.core.UIState
import com.nexxlabs.lynq.data.repository.DashboardRepository
import com.nexxlabs.lynq.model.domain.ListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.delay

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repo: DashboardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<ListModel>>>(UIState.Loading())
    val uiState: StateFlow<UIState<List<ListModel>>> = _uiState

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.value = UIState.Loading()
            delay(250) // UX-friendly small delay (simulated)
            try {
                val lists = repo.getSampleLists()
                _uiState.value = UIState.Success(lists)
            } catch (e: Exception) {
                _uiState.value = UIState.Error("Failed to load dashboard: ${e.message}")
            }
        }
    }

    fun refresh() = load()
}