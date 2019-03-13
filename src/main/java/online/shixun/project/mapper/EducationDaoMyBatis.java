/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import online.shixun.project.entity.EducationEntity;

/**
 * 教育经历 Dao
 */
public interface EducationDaoMyBatis {

    /**
     * 分页获取教育经历列表数据
     * @param language
     * @param pageBounds
     * @return
     */
    public List<EducationEntity> getEducationPages(@Param(value = "language") String language, PageBounds pageBounds);

    /**
     * 根据语言统计教育经历总记录数
     * @param language
     * @return
     */
    public int getEducationsCount(@Param(value = "language") String language);

    /**
     * 根据语言获取所有教育经历数据列表
     * @param language
     * @return
     */
    public List<EducationEntity> getAllEducations(@Param(value = "language") String language);

    /**
     * 根据 ID 获取指定教育经历信息
     * @param id
     * @return
     */
    public EducationEntity getEducation(@Param(value = "id") Long id);

    /**
     * 保存教育经历数据信息
     * @param education
     */
    public void saveEducation(EducationEntity education);

    /**
     * 更新教育经历数据信息
     * @param education
     */
    public void updateEducation(EducationEntity education);

    /**
     * 删除教育经历数据信息
     * @param id
     */
    public void deleteEducation(@Param(value = "id") Long id);
}
