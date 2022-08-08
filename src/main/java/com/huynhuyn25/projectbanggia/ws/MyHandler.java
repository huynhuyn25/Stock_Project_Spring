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
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.File;
import java.util.List;
import java.util.random.*;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class MyHandler extends TextWebSocketHandler {
    List<JsonObject> test = new ArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException, ConfigError, InvalidMessage, FieldNotFound {
        log.info(message.toString());
        ConvertData convertData = new ConvertData();
        test = convertData.ConvertStO(new File("src/main/resources/infogateclient.20200529.dat"));
        int k =0;
        while(k < test.size()){
            session.sendMessage(new TextMessage(test.get(k).toString()));
            k++;
            Thread.sleep((long) (Math.random()*10000));
        }
    }

}