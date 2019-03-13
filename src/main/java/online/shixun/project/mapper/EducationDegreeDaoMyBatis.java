/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.EducationDegreeEntity;

/**
 * 教育程度Dao
 */
public interface EducationDegreeDaoMyBatis {

    /**
     * 根据语言获取所有教育程度数据列表
     * @param language
     * @return
     */
    public List<EducationDegreeEntity> getAllEducationDegrees(@Param("language") String language);
}
