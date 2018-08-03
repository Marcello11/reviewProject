package com.marcello.entity;

import java.util.Date;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/10$ 20:50$
 **/
public class Reply {
    private int id;
    private int msgid;
    private String content;
    private String name;
    private Date date;

    public int getMsgid() {
        return msgid;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
