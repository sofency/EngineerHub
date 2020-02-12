package com.sofency.ssm.pojo;

public class Fame {
    private Integer fameId;

    private String fameName;

    private Integer fameLevel;

    private String famedescription;

    public Integer getFameId() {
        return fameId;
    }

    public void setFameId(Integer fameId) {
        this.fameId = fameId;
    }

    public String getFameName() {
        return fameName;
    }

    public void setFameName(String fameName) {
        this.fameName = fameName == null ? null : fameName.trim();
    }

    public Integer getFameLevel() {
        return fameLevel;
    }

    public void setFameLevel(Integer fameLevel) {
        this.fameLevel = fameLevel;
    }

    public String getFamedescription() {
        return famedescription;
    }

    public void setFamedescription(String famedescription) {
        this.famedescription = famedescription == null ? null : famedescription.trim();
    }
}