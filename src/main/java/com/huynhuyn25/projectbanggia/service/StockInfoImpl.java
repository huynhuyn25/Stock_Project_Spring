package com.huynhuyn25.projectbanggia.service;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StockInfoImpl implements IStockInfoService{

    @Override
    public List<String> getStockInfo() {
        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("1");
        test.add("1");
        test.add("1");


//        ConvertData convertData = new ConvertData();
//        test = convertData.ConvertStO(new File("src/main/resources/infogateclient.20200529.dat"));
        return test;
    }
}
