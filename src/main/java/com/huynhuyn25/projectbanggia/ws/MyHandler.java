package com.huynhuyn25.projectbanggia.ws;

import com.google.gson.JsonObject;
import com.huynhuyn25.projectbanggia.fileData.ConvertData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import quickfix.ConfigError;
import quickfix.DataDictionary;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.random.*;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class MyHandler extends TextWebSocketHandler {


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException, ConfigError, InvalidMessage, FieldNotFound {
        log.info(message.toString());

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/infogateclient.20200529.dat"));
        String line;
        while ((line = reader.readLine()) != null){
            ConvertData convertData = new ConvertData();
            String messageFromData = convertData.ConvertStO(line);
            if(messageFromData!= null) {
                session.sendMessage(new TextMessage(messageFromData));
//                Thread.sleep((long) (Math.random() * 10000));
            }
        }


    }

}