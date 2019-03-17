package com.jnshu.task4.common.bean;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
public class Student implements Serializable {
    private static final long serialVersionUID = -1547199956919434492L;
    private Integer id;
    @NotBlank(message = "{名字不能为空}")
    private String name;

    private String headImg;

    private String career;

    private Integer salary;

    private String careerBrief;

    private Integer type;

    private Integer status;

    private Long createAt;

    private Long updateAt;

    public Student(Integer id, String name, String headImg, String career, Integer salary, String careerBrief, Integer type, Integer status, Long createAt, Long updateAt) {
        this.id = id;
        this.name = name;
        this.headImg = headImg;
        this.career = career;
        this.salary = salary;
        this.careerBrief = careerBrief;
        this.type = type;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCareerBrief() {
        return careerBrief;
    }

    public void setCareerBrief(String careerBrief) {
        this.careerBrief = careerBrief == null ? null : careerBrief.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", career='" + career + '\'' +
                ", salary=" + salary +
                ", careerBrief='" + careerBrief + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}