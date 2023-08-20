package com.hypheno.chatapp.presentation.chat

import com.hypheno.chatapp.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
