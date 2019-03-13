/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.project.entity.SkillEntity;
import online.shixun.project.mapper.SkillDaoMyBatis;

/**
 * 专业技能 Service
 */
@Service
public class SkillService extends BaseService {

    //注入专业技能 Dao
    @Autowired
    private SkillDaoMyBatis skillDao;

    /**
     * 根据语言获取专业技能列表
     * @param language
     * @return
     */
    public List<SkillEntity> getMySkills(String language) {
        return skillDao.getMySkills(language);
    }

    /**
     * 保存专业技能
     * @param skill
     */
    @Transactional
    public void saveMySkill(SkillEntity skill) {
        skillDao.saveMySkill(skill);
    }

    /**
     * 更新专业技能
     * @param skill
     */
    @Transactional
    public void updateMySkill(SkillEntity skill) {
        skillDao.updateMySkill(skill);
    }
}
