package com.mouki.omar.data

import com.mongodb.client.model.InsertOneOptions
import com.mouki.omar.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    private val db:CoroutineDatabase
) : MessageDataSource {
    private val messages = db.getCollection<Message>()
    override suspend fun getAllMessages(): List<Message> {
         val x =  messages.find()
             .descendingSort(Message::timestamp)
             .toList()
        return x
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message, options = InsertOneOptions())
    }
}