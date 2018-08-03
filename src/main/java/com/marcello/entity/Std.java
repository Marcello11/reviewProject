package com.marcello.entity;

public class Std {
    private int id;
    private String stdNum;
    private String stdSex;
    private int stdAge;
    private String stdTel;
    private boolean difference;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDifference(boolean difference) {
        this.difference = difference;
    }

    public boolean isDifference() {
        return difference;
    }

    private String stdPwd;

    public String getStdTel() {
        return stdTel;
    }

    public void setStdTel(String stdTel) {
        this.stdTel = stdTel;
    }

    public String getStdNum() {
        return stdNum;
    }

    public void setStdNum(String stdNum) {
        this.stdNum = stdNum;
    }

    public String getStdSex() {
        return stdSex;
    }

    public void setStdSex(String stdSex) {
        this.stdSex = stdSex;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }


    public String getStdPwd() {
        return stdPwd;
    }

    public void setStdPwd(String stdPwd) {
        this.stdPwd = stdPwd;
    }

}
