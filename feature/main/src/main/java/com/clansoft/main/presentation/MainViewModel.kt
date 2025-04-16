package com.clansoft.main.presentation

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clansoft.main.domain.usecase.ConvertFromUnix
import com.clansoft.main.domain.usecase.ConvertToBitcoin
import com.clansoft.main.domain.usecase.GetNodes
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getNodesUseCase: GetNodes,
    private val convertToBitcoinUseCase: ConvertToBitcoin,
    private val convertFromUnixUseCase: ConvertFromUnix
) : ViewModel() {
    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState(
        nodeList = emptyList()
    ))

    val state: StateFlow<MainState> = _state

    init {
        getNodes()
    }

    fun convertToBitcoin(valueInSat: Long) : Double = convertToBitcoinUseCase(valueInSat)

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertFromUnix(unix: Int) : String? = convertFromUnixUseCase(context, unix)

    private fun getNodes() {
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
