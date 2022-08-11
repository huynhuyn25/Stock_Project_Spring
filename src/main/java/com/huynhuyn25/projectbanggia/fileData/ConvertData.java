package com.huynhuyn25.projectbanggia.fileData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huynhuyn25.projectbanggia.model.StockInfo;
import com.huynhuyn25.projectbanggia.model.TopPrice;
import quickfix.*;
import quickfix.field.Message;
import quickfix.field.MessageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ConvertData {
    ArrayList<StockInfo> listStockInfo = new ArrayList<>();
    public String ConvertStO(String line) throws IOException, ConfigError, InvalidMessage, FieldNotFound {
        DataDictionary dictionary = new DataDictionary("src/main/resources/CustomFIX.xml");
        Message messageFromMessageUtils = (Message) MessageUtils.parse(new MessageFactory(), dictionary, line, false);
        List<JsonObject> listJsonData = new ArrayList<>();
        JsonObject jsonObject = new JsonObject();
        String msgType = ((Message.Header) messageFromMessageUtils.getHeader()).getMsgType().getValue();
        jsonObject.addProperty("MsgType",msgType);
        Iterator<Field<?>> iterator = messageFromMessageUtils.iterator();
        while (iterator.hasNext()) {
            Field<?> field = iterator.next();
            jsonObject.addProperty(dictionary.getFieldName(field.getField()) != null ? dictionary.getFieldName(field.getField()) : "" + field.getTag() + "", (String) (field.getObject() != null ? field.getObject() : ""));
        }
        listJsonData.add(jsonObject);
        Iterator<Integer> iteratorKeys = messageFromMessageUtils.groupKeyIterator();
        int key;
        while (iteratorKeys.hasNext()) {
            key = iteratorKeys.next();
            for (Group group : messageFromMessageUtils.getGroups(key)) {
                iterator = group.iterator();
                jsonObject = new JsonObject();
                while (iterator.hasNext()) {
                    Field<?> field = iterator.next();
                    jsonObject.addProperty(dictionary.getFieldName(field.getField()) != null ? dictionary.getFieldName(field.getField()) : "" + field.getTag() + "", (String) (field.getObject() != null ? field.getObject() : ""));
                }
                listJsonData.add(jsonObject);
            }
            }
        String messageSend;
        if(msgType.equals("SI")) messageSend = convertSI(listJsonData);
        else if(msgType.equals("TP")) messageSend = convertTP(listJsonData);
        else return null;

        return messageSend;

    }

    private String convertTP(List<JsonObject> listJsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = listJsonData.get(0);
        if(listStockInfo.size()!=0){
            String symbol = subString(gson.toJson(jsonObject.get("Symbol")));
            for (StockInfo stockInfo:listStockInfo){
                if(symbol.equals(stockInfo.getSymbol())){

                }
            }
        }
        return gson.toJson(listJsonData);
    }

    private String convertSI(List<JsonObject> listJsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = listJsonData.get(0);
        StockInfo stockInfo = new StockInfo(subString(gson.toJson(jsonObject.get("Symbol"))),
                subString(gson.toJson(jsonObject.get("BasicPrice"))),
                subString(gson.toJson(jsonObject.get("CeilingPrice"))),
                subString(gson.toJson(jsonObject.get("FloorPrice"))));
        listStockInfo.add(stockInfo);
        return gson.toJson(stockInfo);
    }

    private String subString(String s){
        return s.substring(1,s.length()-1);
    }
}
