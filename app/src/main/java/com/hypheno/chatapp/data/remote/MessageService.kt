package com.hypheno.chatapp.data.remote

import com.hypheno.chatapp.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.0.172:8080"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages : Endpoints("$BASE_URL/messages")
    }
}