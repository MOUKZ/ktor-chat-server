package com.mouki.omar.plugins

import com.mouki.omar.reoutes.chatSocket
import com.mouki.omar.reoutes.getAllMessages
import com.mouki.omar.room.RoomController
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
