package com.huynhuyn25.projectbanggia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//public class MessageController {
//
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @MessageMapping()
//    public String sendMessage(String message) {
//        simpMessagingTemplate.convertAndSend("/topic" , "hello");
////        System.out.println("handling send message: " + message + " to: " + to);
////        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
////        if (isExists) {
////
////        }
//        return message;
//    }
//}
