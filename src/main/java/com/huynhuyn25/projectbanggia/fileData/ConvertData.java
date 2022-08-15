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
    private static HashMap<String,StockInfo> hashMapStock = new HashMap<>();
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
        StockInfo si = new StockInfo();
        JsonObject jsonObject = listJsonData.get(0);
//        System.out.println(listStockInfo.size());
        String symbol = subString(gson.toJson(jsonObject.get("Symbol")));
        if(!hashMapStock.isEmpty()&&hashMapStock.containsKey(symbol)){
            int noTopPrice = Integer.parseInt(subString(gson.toJson(jsonObject.get("NoTopPrice"))));
            StockInfo stockInfo = hashMapStock.get(symbol);
            ArrayList<TopPrice> listTopPrice = new ArrayList<>();
            int k = 1;
            while(k<=3&&noTopPrice!=0){
                JsonObject jsonObject1 = listJsonData.get(k);
                TopPrice topOfferPrice = new TopPrice(subString(gson.toJson(jsonObject1.get("NumTopPrice"))),"Offer",subString(gson.toJson(jsonObject1.get("BestOfferPrice"))),subString(gson.toJson(jsonObject1.get("BestOfferQtty"))));
                TopPrice topBidPrice = new TopPrice(subString(gson.toJson(jsonObject1.get("NumTopPrice"))),"Bid",subString(gson.toJson(jsonObject1.get("BestBidPrice"))),subString(gson.toJson(jsonObject1.get("BestBidQtty"))));
                listTopPrice.add(topOfferPrice);
                listTopPrice.add(topBidPrice);
                System.out.println(topBidPrice);
                System.out.println(topOfferPrice);
                k++;
                noTopPrice--;
            }
            stockInfo.setListTP(listTopPrice);
            stockInfo.setStatus("update");
            si = stockInfo;
            return gson.toJson(si);
        }
        return null;
    }

    private String convertSI(List<JsonObject> listJsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = listJsonData.get(0);
//        System.out.println(subString(gson.toJson(jsonObject.get("Symbol"))));
        String symbol= subString(gson.toJson(jsonObject.get("Symbol")));
//        System.out.println(symbol);
        if(!hashMapStock.containsKey(symbol)||hashMapStock.isEmpty()){
            StockInfo stockInfo = new StockInfo(subString(gson.toJson(jsonObject.get("Symbol"))),
                    subString(gson.toJson(jsonObject.get("BasicPrice"))),
                    subString(gson.toJson(jsonObject.get("CeilingPrice"))),
                    subString(gson.toJson(jsonObject.get("FloorPrice"))),
                    "create");
            hashMapStock.put(subString(gson.toJson(jsonObject.get("Symbol"))),stockInfo);
//            System.out.println(hashMapStock.get(subString(gson.toJson(jsonObject.get("Symbol")))));
            return gson.toJson(stockInfo);
        }

//        listStockInfo.add(stockInfo);
        return null;
    }

    private String subString(String s){
        return s.substring(1,s.length()-1);
    }
}
