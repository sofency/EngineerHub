package com.sofency.ssm.pojo;

import java.io.Serializable;

public class Major extends MajorKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String majorname;

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }
}