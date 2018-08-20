package com.cloth.clothes.bean;


public class Clothes {

  private long id;
  private String name;
  private String feature;//属性
  private String brand;//品牌
  private String type;//类型（男装，女装）
  private double size;//尺码
  private String texture;//材质
  private String couar;//领型
  private String sleeve;//袖长
  private String batch;//批次
  private double cost;//进价
  private long number;//数量
  private double profit;//单品利润
  private String clothesUrl;//图片地址


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


  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
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


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }


  public double getProfit() {
    return profit;
  }

  public void setProfit(double profit) {
    this.profit = profit;
  }

  public String getClothesUrl() {
    return clothesUrl;
  }

  public void setClothesUrl(String clothesUrl) {
    this.clothesUrl = clothesUrl;
  }
}
