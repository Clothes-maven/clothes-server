package com.cloth.clothes.bean;


public class SellOut {

    private long subId;
    private Clothdetail clothdetail;
    private String sell;
    private User user;
    private String createDate;

    public long getSubId() {
        return subId;
    }

    public void setSubId(long subId) {
        this.subId = subId;
    }

    public Clothdetail getClothdetail() {
        return clothdetail;
    }

    public void setClothdetail(Clothdetail clothdetail) {
        this.clothdetail = clothdetail;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
