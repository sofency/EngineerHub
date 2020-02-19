package com.sofency.ssm.pojo;

import java.io.Serializable;

public class Manager implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer managerid;

    private String username;

    private String userpwd;

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }
}