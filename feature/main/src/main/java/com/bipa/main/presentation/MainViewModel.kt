package com.bipa.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bipa.main.domain.usecase.GetNodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNodesUseCase: GetNodesUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState(
        nodeList = emptyList(),
        isRefreshing = false,
        isLoading = false
    ))
    val state: StateFlow<MainState> = _state

    private val _eventFlow = MutableSharedFlow<MainUIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getNodes()
    }

    fun onEvent(event: MainUIEvent) {
        when(event) {
            is MainUIEvent.Refresh -> {
                _state.update { it.copy(isRefreshing = true) }
                getNodes()
            }
        }
    }

    private fun getNodes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = !it.isRefreshing) }
            getNodesUseCase()
                .onSuccess { result ->
                    _state.update { it.copy(nodeList = result) }
                }
                .onFailure {
                    _eventFlow.emit(MainUIEvent.ShowSnackBar("Something went wrong"))
                }
            _state.update { it.copy(isLoading = false, isRefreshing = false) }
        }
    }
}
