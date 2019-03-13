/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.SkillEntity;

/**
 * 专业技能Dao
 */
public interface SkillDaoMyBatis {

    /**
     * 根据语言获取我的专业技能信息
     * @param language
     * @return
     */
    public List<SkillEntity> getMySkills(@Param("language") String language);

    /**
     * 保存我的专业技能信息
     * @param skill
     */
    public void saveMySkill(SkillEntity skill);

    /**
     * 更新我的专业技能信息
     * @param skill
     */
    public void updateMySkill(SkillEntity skill);
}
