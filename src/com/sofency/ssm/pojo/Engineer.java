package com.sofency.ssm.pojo;

public class Engineer {
    private Integer engineerId;

    private String engineerName;

    private String engineerImgpath;

    private String engineerSex;

    private String engineerTel;

    private String engineerEmail;

    private Integer instid;

    private Integer majorid;

    private String engineerMotto;

    private String engineerGit;

    public Integer getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(Integer engineerId) {
        this.engineerId = engineerId;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName == null ? null : engineerName.trim();
    }

    public String getEngineerImgpath() {
        return engineerImgpath;
    }

    public void setEngineerImgpath(String engineerImgpath) {
        this.engineerImgpath = engineerImgpath == null ? null : engineerImgpath.trim();
    }

    public String getEngineerSex() {
        return engineerSex;
    }

    public void setEngineerSex(String engineerSex) {
        this.engineerSex = engineerSex == null ? null : engineerSex.trim();
    }

    public String getEngineerTel() {
        return engineerTel;
    }

    public void setEngineerTel(String engineerTel) {
        this.engineerTel = engineerTel == null ? null : engineerTel.trim();
    }

    public String getEngineerEmail() {
        return engineerEmail;
    }

    public void setEngineerEmail(String engineerEmail) {
        this.engineerEmail = engineerEmail == null ? null : engineerEmail.trim();
    }

    public Integer getInstid() {
        return instid;
    }

    public void setInstid(Integer instid) {
        this.instid = instid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getEngineerMotto() {
        return engineerMotto;
    }

    public void setEngineerMotto(String engineerMotto) {
        this.engineerMotto = engineerMotto == null ? null : engineerMotto.trim();
    }

    public String getEngineerGit() {
        return engineerGit;
    }

    public void setEngineerGit(String engineerGit) {
        this.engineerGit = engineerGit == null ? null : engineerGit.trim();
    }
}