package com.marcello.entity;



import java.util.Date;
import java.util.List;

/**
 * @Description帖子实体类
 * @Author mcsb
 * CreateDate 2018/4/10$ 17:25$
 **/
public class Posting {
    private int id;
    private String bssName;
    private String bssTitle;
    private String bssMsg;
    private Date date;
    private List<Reply> replys;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }

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

    public String getBssTitle() {
        return bssTitle;
    }

    public void setBssTitle(String bssTitle) {
        this.bssTitle = bssTitle;
    }

    public String getBssMsg() {
        return bssMsg;
    }

    public void setBssMsg(String bssMsg) {
        this.bssMsg = bssMsg;
    }
}
