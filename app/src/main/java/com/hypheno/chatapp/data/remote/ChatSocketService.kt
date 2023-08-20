package com.hypheno.chatapp.data.remote

import com.hypheno.chatapp.domain.model.Message
import com.hypheno.chatapp.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(username: String): NetworkResult<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://192.168.0.172:8080"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket : Endpoints("$BASE_URL/chat-socket")
    }
}