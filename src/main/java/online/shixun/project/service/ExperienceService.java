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

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import online.shixun.project.entity.ExperienceEntity;
import online.shixun.project.mapper.ExperienceDaoMyBatis;

/**
 * 工作经验 Service
 */
@Service
public class ExperienceService extends BaseService {

    //注入工作经验 Dao
    @Autowired
    private ExperienceDaoMyBatis experienceDao;

    /**
     * 分页获取工作经验列表数据
     * @param language
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<ExperienceEntity> getExperiencePages(String language, int pageNo, int pageSize) {
        //定义分页参数信息
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        //获取分页数据
        return experienceDao.getExperiencePages(language, pageBounds);

    }

    /**
     * 根据每页显示记录数，计算工作经验总页数
     * @param language
     * @param pageSize
     * @return
     */
    public Integer getTotalPage(String language, int pageSize) {
        return countTotalPage(experienceDao.getExperiencesCount(language), pageSize);
    }

    /**
     * 根据语言获取所有工作经验数据列表
     * @param language
     * @return
     */
    public List<ExperienceEntity> getAllExperiences(String language) {
        return experienceDao.getAllExperiences(language);
    }

    /**
     * 根据 ID 获取指定工作经验信息
     * @param id
     * @return
     */
    public ExperienceEntity getExperience(Long id) {
        return experienceDao.getExperience(id);
    }

    /**
     * 保存工作经验数据信息
     * @param experience
     */
    @Transactional
    public void saveExperience(ExperienceEntity experience) {
        experienceDao.saveExperience(experience);
    }

    /**
     * 更新工作经验数据信息
     * @param experience
     */
    @Transactional
    public void updateExperience(ExperienceEntity experience) {
        experienceDao.updateExperience(experience);
    }

    /**
     * 删除工作经验数据信息
     * @param id
     */
    @Transactional
    public void deleteExperience(Long id) {
        experienceDao.deleteExperience(id);
    }
}
