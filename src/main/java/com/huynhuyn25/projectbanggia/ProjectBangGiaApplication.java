package com.huynhuyn25.projectbanggia;

import com.huynhuyn25.projectbanggia.fileData.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.FileNotFoundException;

@SpringBootApplication
public class ProjectBangGiaApplication implements CommandLineRunner {

    @Autowired
    ReadFile readFile;

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(ProjectBangGiaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        readFile.readFileData();
    }
}
