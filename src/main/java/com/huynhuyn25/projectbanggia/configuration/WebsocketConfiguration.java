package com.huynhuyn25.projectbanggia.configuration;

import com.huynhuyn25.projectbanggia.ws.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyHandler(), "/topPrice")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }
    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
}