package com.hypheno.chatapp.data.remote

import com.hypheno.chatapp.data.remote.dto.MessageDto
import com.hypheno.chatapp.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList<Message>()
        }
    }
}