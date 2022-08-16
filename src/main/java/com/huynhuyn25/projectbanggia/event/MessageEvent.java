package com.huynhuyn25.projectbanggia.event;

import com.huynhuyn25.projectbanggia.model.StockInfo;
import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    private String message;
    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
