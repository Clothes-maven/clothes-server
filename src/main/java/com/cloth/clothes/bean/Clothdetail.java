package com.cloth.clothes.bean;


public class Clothdetail {

    private long id;
    private double size;//尺寸
    private String color;//颜色
    private Store store;
    private long number;//数量
    private Clothes clothe;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Clothes getClothe() {
        return clothe;
    }

    public void setClothe(Clothes clothe) {
        this.clothe = clothe;
    }
}
