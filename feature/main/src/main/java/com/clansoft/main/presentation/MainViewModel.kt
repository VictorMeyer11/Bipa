package com.clansoft.main.presentation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clansoft.main.R
import com.clansoft.main.domain.usecase.ConvertFromUnix
import com.clansoft.main.domain.usecase.ConvertToBitcoin
import com.clansoft.main.domain.usecase.GetNodes
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getNodesUseCase: GetNodes,
    private val convertToBitcoinUseCase: ConvertToBitcoin,
    private val convertFromUnixUseCase: ConvertFromUnix
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

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.Refresh -> {
                _state.update { it.copy(isRefreshing = true) }
                getNodes()
            }
        }
    }

    fun convertToBitcoin(valueInSat: Long) : Double? = convertToBitcoinUseCase(valueInSat)

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertFromUnix(unix: Int) : String? = convertFromUnixUseCase(unix)

    private fun getNodes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = !it.isRefreshing) }
            getNodesUseCase()
                .onSuccess { result ->
                    _state.update { it.copy(nodeList = result) }
                }
                .onFailure {
                    _eventFlow.emit(MainUIEvent.ShowSnackBar(context.getString(R.string.something_went_wrong)))
                }
            _state.update { it.copy(isLoading = false, isRefreshing = false) }
        }
    }
}
