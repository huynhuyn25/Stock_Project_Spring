package com.huynhuyn25.projectbanggia.ws;

import com.google.gson.JsonObject;
import com.huynhuyn25.projectbanggia.fileData.ConvertData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.handler.WebSocketSessionDecorator;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;
import quickfix.ConfigError;
import quickfix.DataDictionary;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.random.*;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class MyHandler extends TextWebSocketHandler  {

    private String messageSend;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException, ConfigError, InvalidMessage, FieldNotFound {
//        while(session!=null){
//            if(messageSend!=null){
//
//                session.sendMessage(new TextMessage(messageSend));
//                messageSend = null;
//            }
//        }

    }


}