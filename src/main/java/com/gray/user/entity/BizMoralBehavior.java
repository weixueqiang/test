package com.gray.user.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BizMoralBehavior {
    private String id;

    private String schoolId;

    private String behaviorLibId;

    private String behaviorGroupId;

    private String name;

    private BigDecimal score;

    private Integer seq;

    private Date createTime;

    private Date updateTime;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getBehaviorLibId() {
        return behaviorLibId;
    }

    public void setBehaviorLibId(String behaviorLibId) {
        this.behaviorLibId = behaviorLibId == null ? null : behaviorLibId.trim();
    }

    public String getBehaviorGroupId() {
        return behaviorGroupId;
    }

    public void setBehaviorGroupId(String behaviorGroupId) {
        this.behaviorGroupId = behaviorGroupId == null ? null : behaviorGroupId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}