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

import online.shixun.project.entity.ExperienceEntity;

/**
 * 工作经验 Dao
 */
public interface ExperienceDaoMyBatis {

    /**
     * 分页获取工作经验列表数据
     * @param language
     * @param pageBounds
     * @return
     */
    public List<ExperienceEntity> getExperiencePages(@Param(value = "language") String language, PageBounds pageBounds);

    /**
     * 根据语言统计工作经验总记录数
     * @param language
     * @return
     */
    public int getExperiencesCount(@Param(value = "language") String language);

    /**
     * 根据语言获取所有工作经验数据列表
     * @param language
     * @return
     */
    public List<ExperienceEntity> getAllExperiences(@Param(value = "language") String language);

    /**
     * 根据 ID 获取指定工作经验信息
     * @param id
     * @return
     */
    public ExperienceEntity getExperience(@Param(value = "id") Long id);

    /**
     * 保存工作经验数据信息
     * @param experience
     */
    public void saveExperience(ExperienceEntity experience);

    /**
     * 更新工作经验数据信息
     * @param experience
     */
    public void updateExperience(ExperienceEntity experience);

    /**
     * 删除工作经验数据信息
     * @param id
     */
    public void deleteExperience(@Param(value = "id") Long id);
}
