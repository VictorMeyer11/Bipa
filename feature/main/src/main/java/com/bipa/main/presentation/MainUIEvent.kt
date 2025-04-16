package com.bipa.main.presentation

interface MainUIEvent {
    data class ShowSnackBar(val message: String) : MainUIEvent
    data object Refresh : MainUIEvent
}
