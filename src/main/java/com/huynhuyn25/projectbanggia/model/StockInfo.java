package com.huynhuyn25.projectbanggia.model;

import java.util.ArrayList;
import java.util.List;

public class StockInfo {
    private String symbol;
    private String thamChieu;
    private String giaTran;
    private String giaSan;
    private List<TopPrice> listTP = new ArrayList<>();

    public StockInfo(String symbol, String thamChieu, String giaTran, String giaSan) {
        this.symbol = symbol;
        this.thamChieu = thamChieu;
        this.giaTran = giaTran;
        this.giaSan = giaSan;
    }

    public StockInfo() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getThamChieu() {
        return thamChieu;
    }

    public void setThamChieu(String thamChieu) {
        this.thamChieu = thamChieu;
    }

    public String getGiaTran() {
        return giaTran;
    }

    public void setGiaTran(String giaTran) {
        this.giaTran = giaTran;
    }

    public String getGiaSan() {
        return giaSan;
    }

    public void setGiaSan(String giaSan) {
        this.giaSan = giaSan;
    }

    public List<TopPrice> getListTP() {
        return listTP;
    }

    public void setListTP(List<TopPrice> listTP) {
        this.listTP = listTP;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "symbol='" + symbol + '\'' +
                ", thamChieu='" + thamChieu + '\'' +
                ", giaTran='" + giaTran + '\'' +
                ", giaSan='" + giaSan + '\'' +
                ", listTP=" + listTP +
                '}';
    }
}
