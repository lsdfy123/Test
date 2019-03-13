/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.WorkingStatusEntity;

/**
 * 工作状态Dao
 */
public interface WorkingStatusDaoMyBatis {

    /**
     * 根据语言获取所有工作状态数据列表
     * @param language
     * @return
     */
    public List<WorkingStatusEntity> getAllWorkingStatus(@Param("language") String language);
}
