package com.gray.user.entity;

public class LevelAndScoreRelevance {
    private String id;

    private String configurationId;

    private String levelName;

    private Integer levelScoreRangeBegin;

    private Integer levelScoreRangeEnd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId == null ? null : configurationId.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getLevelScoreRangeBegin() {
        return levelScoreRangeBegin;
    }

    public void setLevelScoreRangeBegin(Integer levelScoreRangeBegin) {
        this.levelScoreRangeBegin = levelScoreRangeBegin;
    }

    public Integer getLevelScoreRangeEnd() {
        return levelScoreRangeEnd;
    }

    public void setLevelScoreRangeEnd(Integer levelScoreRangeEnd) {
        this.levelScoreRangeEnd = levelScoreRangeEnd;
    }
}