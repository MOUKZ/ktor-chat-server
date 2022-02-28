package com.mouki.omar.data

import com.mouki.omar.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages():List<Message>

    suspend fun insertMessage(message: Message)
}