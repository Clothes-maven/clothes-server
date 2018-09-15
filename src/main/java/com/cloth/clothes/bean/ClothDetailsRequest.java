package com.cloth.clothes.bean;

public class ClothDetailsRequest {
    private double size;//尺寸
    private String color;//颜色
    private int storeId;
    private long number;//数量
    private int clotheId;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getClotheId() {
        return clotheId;
    }

    public void setClotheId(int clotheId) {
        this.clotheId = clotheId;
    }
}
