package com.huynhuyn25.projectbanggia.fileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import quickfix.ConfigError;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@Service
public class ReadFile   {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate ;

    public void readFileData() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/infogateclient.20200529.dat"));
        String line;
        while (true){
            try {
                if (!((line = reader.readLine()) != null)) break;
                ConvertData convertData = new ConvertData();
                String message  = convertData.ConvertStO(line);

                if(message!=null){
                    this.simpMessagingTemplate.convertAndSend("/topic/topPrice",message);
                }
            } catch (ConfigError e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidMessage e) {
                e.printStackTrace();
            } catch (FieldNotFound e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
