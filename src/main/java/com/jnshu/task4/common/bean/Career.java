package com.jnshu.task4.common.bean;

import java.io.Serializable;

public class Career implements Serializable {

    private static final long serialVersionUID = -2995931505512382165L;
    private Integer id;

    private String headImg;

    private String name;

    private String careerBrief;

    private Integer threshold;

    private Integer satisfaction;

    private Integer growthCycle;

    private Integer scarcity;

    private Integer payZeroOne;

    private Integer payOneThree;

    private Integer payThreeFive;

    private Integer num;

    private String need;

    private String careerType;

    private String careerDetails;

    private Long createAt;

    private Long updateAt;

    public Career(Integer id, String headImg, String name, String careerBrief, Integer threshold, Integer satisfaction, Integer growthCycle, Integer scarcity, Integer payZeroOne, Integer payOneThree, Integer payThreeFive, Integer num, String need, String careerType, String careerDetails, Long createAt, Long updateAt) {
        this.id = id;
        this.headImg = headImg;
        this.name = name;
        this.careerBrief = careerBrief;
        this.threshold = threshold;
        this.satisfaction = satisfaction;
        this.growthCycle = growthCycle;
        this.scarcity = scarcity;
        this.payZeroOne = payZeroOne;
        this.payOneThree = payOneThree;
        this.payThreeFive = payThreeFive;
        this.num = num;
        this.need = need;
        this.careerType = careerType;
        this.careerDetails = careerDetails;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Career() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCareerBrief() {
        return careerBrief;
    }

    public void setCareerBrief(String careerBrief) {
        this.careerBrief = careerBrief == null ? null : careerBrief.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Integer getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(Integer growthCycle) {
        this.growthCycle = growthCycle;
    }

    public Integer getScarcity() {
        return scarcity;
    }

    public void setScarcity(Integer scarcity) {
        this.scarcity = scarcity;
    }

    public Integer getPayZeroOne() {
        return payZeroOne;
    }

    public void setPayZeroOne(Integer payZeroOne) {
        this.payZeroOne = payZeroOne;
    }

    public Integer getPayOneThree() {
        return payOneThree;
    }

    public void setPayOneThree(Integer payOneThree) {
        this.payOneThree = payOneThree;
    }

    public Integer getPayThreeFive() {
        return payThreeFive;
    }

    public void setPayThreeFive(Integer payThreeFive) {
        this.payThreeFive = payThreeFive;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need == null ? null : need.trim();
    }

    public String getCareerType() {
        return careerType;
    }

    public void setCareerType(String careerType) {
        this.careerType = careerType == null ? null : careerType.trim();
    }

    public String getCareerDetails() {
        return careerDetails;
    }

    public void setCareerDetails(String careerDetails) {
        this.careerDetails = careerDetails == null ? null : careerDetails.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", headImg='" + headImg + '\'' +
                ", name='" + name + '\'' +
                ", careerBrief='" + careerBrief + '\'' +
                ", threshold=" + threshold +
                ", satisfaction=" + satisfaction +
                ", growthCycle=" + growthCycle +
                ", scarcity=" + scarcity +
                ", payZeroOne=" + payZeroOne +
                ", payOneThree=" + payOneThree +
                ", payThreeFive=" + payThreeFive +
                ", num=" + num +
                ", need='" + need + '\'' +
                ", careerType='" + careerType + '\'' +
                ", careerDetails='" + careerDetails + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}