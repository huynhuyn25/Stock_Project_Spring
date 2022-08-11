package com.huynhuyn25.projectbanggia.model;

public class TopPrice {
    private String top;
    private String ben;
    private String gia;
    private String khoiLuong;

    public TopPrice(String top, String ben, String gia, String khoiLuong) {
        this.top = top;
        this.ben = ben;
        this.gia = gia;
        this.khoiLuong = khoiLuong;
    }

    public TopPrice() {
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBen() {
        return ben;
    }

    public void setBen(String ben) {
        this.ben = ben;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
}
