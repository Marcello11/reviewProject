package com.marcello.entity;

import java.util.Date;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 16:38$
 **/
public class Business {
    private int id;
    private String bssName;
    private String bssTel;
    private String bssPwd;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBssName() {
        return bssName;
    }

    public void setBssName(String bssName) {
        this.bssName = bssName;
    }

    public String getBssTel() {
        return bssTel;
    }

    public void setBssTel(String bssTel) {
        this.bssTel = bssTel;
    }

    public String getBssPwd() {
        return bssPwd;
    }

    public void setBssPwd(String bssPwd) {
        this.bssPwd = bssPwd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
