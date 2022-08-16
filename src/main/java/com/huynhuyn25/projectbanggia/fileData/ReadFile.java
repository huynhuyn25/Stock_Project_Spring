package com.huynhuyn25.projectbanggia.fileData;

import quickfix.ConfigError;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public void ReadFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/infogateclient.20200529.dat"));
        String line;
        while (true){
            try {
                if (!((line = reader.readLine()) != null)) break;
                ConvertData convertData = new ConvertData();
                convertData.ConvertStO(line);

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
