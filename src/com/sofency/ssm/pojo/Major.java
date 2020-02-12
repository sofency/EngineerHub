package com.sofency.ssm.pojo;

public class Major extends MajorKey {
    private String majorname;

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }
}