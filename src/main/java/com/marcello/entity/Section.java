package com.marcello.entity;

import java.util.Date;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 16:35$
 **/
public class Section {
    private int id;
    private  String sectionName;
    private String sectionTel;
    private String sectionPwd;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionTel() {
        return sectionTel;
    }

    public void setSectionTel(String sectionTel) {
        this.sectionTel = sectionTel;
    }

    public String getSectionPwd() {
        return sectionPwd;
    }

    public void setSectionPwd(String sectionPwd) {
        this.sectionPwd = sectionPwd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
