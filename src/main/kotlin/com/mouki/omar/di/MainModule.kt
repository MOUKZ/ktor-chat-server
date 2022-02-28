package com.mouki.omar.di

import com.mouki.omar.data.MessageDataSource
import com.mouki.omar.data.MessageDataSourceImpl
import com.mouki.omar.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db")
    }
    single<MessageDataSource> {

        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}