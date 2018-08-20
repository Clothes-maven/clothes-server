package com.cloth.clothes.bean;


public class SellOut {

  private long subid;
  private long clothesId;
  private String sell;
  private long userId;


  public long getSubid() {
    return subid;
  }

  public void setSubid(long subid) {
    this.subid = subid;
  }


  public long getClothesId() {
    return clothesId;
  }

  public void setClothesId(long clothesId) {
    this.clothesId = clothesId;
  }


  public String getSell() {
    return sell;
  }

  public void setSell(String sell) {
    this.sell = sell;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
