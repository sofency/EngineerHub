package com.sofency.ssm.pojo;

import java.io.Serializable;

public class Institude implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer instid;

    private String instname;

    public Integer getInstid() {
        return instid;
    }

    public void setInstid(Integer instid) {
        this.instid = instid;
    }

    public String getInstname() {
        return instname;
    }

    public void setInstname(String instname) {
        this.instname = instname == null ? null : instname.trim();
    }
}