package com.huynhuyn25.projectbanggia.service;

import com.google.gson.JsonObject;
import com.huynhuyn25.projectbanggia.fileData.ConvertData;
import com.huynhuyn25.projectbanggia.model.StockInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class StockInfoImpl implements IStockInfoService{

    @Override
    public List<StockInfo> getStockInfo() {
        List<StockInfo> listStock = new ArrayList<>();
        ConvertData convertData = new ConvertData();
        HashMap<String,StockInfo> hashMapStock = convertData.getHashMapStock();
        Set<String> setKey = hashMapStock.keySet();
        for (String key : setKey){
            listStock.add(hashMapStock.get(key));
        }
        return listStock;
    }
}
