package com.clansoft.main.presentation

interface MainUIEvent {
    data class ShowSnackBar(val message: String) : MainUIEvent
}
