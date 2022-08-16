package com.huynhuyn25.projectbanggia;

import com.huynhuyn25.projectbanggia.fileData.ConvertData;
import com.huynhuyn25.projectbanggia.fileData.ReadFile;
import com.huynhuyn25.projectbanggia.ws.MyHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;
import quickfix.ConfigError;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class ProjectBangGiaApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(ProjectBangGiaApplication.class, args);
        ReadFile readFile = new ReadFile();
        readFile.ReadFile();
    }

}
