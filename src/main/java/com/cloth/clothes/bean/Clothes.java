package com.cloth.clothes.bean;


public class Clothes {

    private long id;
    private String name;
    private String feature;//属性
    private String brand;//品牌
    private String type;//类型（男装，女装）
    private String texture;//材质
    private String couar;//领型
    private String sleeve;//袖长
    private String batch;//批次
    private double cost;//进价
    private String clothesUrl;//图片地址
    private String supplier;//供应商
    private String pay;//是否支付，1是支付，0未支付


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }


    public String getCouar() {
        return couar;
    }

    public void setCouar(String couar) {
        this.couar = couar;
    }


    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public String getClothesUrl() {
        return clothesUrl;
    }

    public void setClothesUrl(String clothesUrl) {
        this.clothesUrl = clothesUrl;
    }


    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
