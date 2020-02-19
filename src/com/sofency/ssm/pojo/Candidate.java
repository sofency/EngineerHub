package com.sofency.ssm.pojo;

import java.io.Serializable;

public class Candidate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer candidateId;

    private Integer instid;

    private Integer majorid;

    private String candidateName;

    private String candidateSex;

    private String candidateTel;

    private String candidateEmail;

    private String candidateIntroduce;

    private String candidateFame;

    private Byte candidatestatus;

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
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

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName == null ? null : candidateName.trim();
    }

    public String getCandidateSex() {
        return candidateSex;
    }

    public void setCandidateSex(String candidateSex) {
        this.candidateSex = candidateSex == null ? null : candidateSex.trim();
    }

    public String getCandidateTel() {
        return candidateTel;
    }

    public void setCandidateTel(String candidateTel) {
        this.candidateTel = candidateTel == null ? null : candidateTel.trim();
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail == null ? null : candidateEmail.trim();
    }

    public String getCandidateIntroduce() {
        return candidateIntroduce;
    }

    public void setCandidateIntroduce(String candidateIntroduce) {
        this.candidateIntroduce = candidateIntroduce == null ? null : candidateIntroduce.trim();
    }

    public String getCandidateFame() {
        return candidateFame;
    }

    public void setCandidateFame(String candidateFame) {
        this.candidateFame = candidateFame == null ? null : candidateFame.trim();
    }

    public Byte getCandidatestatus() {
        return candidatestatus;
    }

    public void setCandidatestatus(Byte candidatestatus) {
        this.candidatestatus = candidatestatus;
    }
}