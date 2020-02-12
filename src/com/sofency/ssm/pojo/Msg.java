package com.sofency.ssm.pojo;

import java.util.Date;

public class Msg {
    private Integer msgid;

    private String msgheader;

    private Date msgtime;

    private Integer msgvisited;

    private String msgcontent;

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getMsgheader() {
        return msgheader;
    }

    public void setMsgheader(String msgheader) {
        this.msgheader = msgheader == null ? null : msgheader.trim();
    }

    public Date getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(Date msgtime) {
        this.msgtime = msgtime;
    }

    public Integer getMsgvisited() {
        return msgvisited;
    }

    public void setMsgvisited(Integer msgvisited) {
        this.msgvisited = msgvisited;
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent == null ? null : msgcontent.trim();
    }
}