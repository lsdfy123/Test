/*****************************************************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package online.shixun.project.entity;

import java.io.Serializable;
import java.util.Date;

import online.shixun.project.utils.DateUtils;

/**
 * 实体类 基类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 6342013144651268092L;

    protected Long id = 0L;

    //语言：en_US 英文 ； zh_CN 中文
    protected String language = "zh_CN";

    //创建日期时间
    protected Date createTime = new Date(System.currentTimeMillis());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return DateUtils.timeToString(this.createTime);
    }
}
