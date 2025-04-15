package com.clansoft.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clansoft.main.domain.usecase.GetNodes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNodesUseCase: GetNodes
) : ViewModel() {
    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState(
        nodeList = emptyList()
    ))

    val state: StateFlow<MainState> = _state

    init {
        getNodes()
    }

    fun getNodes() {
        viewModelScope.launch {
            getNodesUseCase()
                .onSuccess { result ->
                    _state.update { it.copy(nodeList = result) }
                }
                .onFailure { error ->
                    Log.d("ERROR", error.message.toString())
                }
        }
    }
}
