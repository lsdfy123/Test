/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import online.shixun.project.utils.DateUtils;

/**
 * 我的基本信息实体类
 */
public class AboutMeEntity extends BaseEntity {

	private static final long serialVersionUID = 1349171688706245282L;

	//姓名
    private String name;

    //性别
    private String gender = "Male";

    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    //人生格言
    private String motto;

    //学历
    private EducationDegreeEntity educationDegree = new EducationDegreeEntity();

    //工作年限
    private String workingYears;

    //工作状态
    private WorkingStatusEntity workingStatus = new WorkingStatusEntity();

    //居住地
    private String residence;

    //邮件
    private String email;

    //手机
    private String mobile;

    //简历文件
    private String resumeFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthdayStr() {
        return DateUtils.dateToString(this.birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public EducationDegreeEntity getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegreeEntity educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }

    public WorkingStatusEntity getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(WorkingStatusEntity workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(String resumeFile) {
        this.resumeFile = resumeFile;
    }

    @Override
    public String toString() {
        return "AboutMeEntity [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", motto=" + motto + ", educationDegree=" + educationDegree + ", workingYears=" + workingYears + ", workingStatus=" + workingStatus + ", residence=" + residence + ", email=" + email + ", mobile=" + mobile + ", resumeFile=" + resumeFile + "]";
    }

}
