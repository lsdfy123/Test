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

import online.shixun.project.entity.EducationEntity;
import online.shixun.project.mapper.EducationDaoMyBatis;

/**
 * 教育经历 Service
 */
@Service
public class EducationService extends BaseService {

    //注入教育经历 Dao
    @Autowired
    private EducationDaoMyBatis educationDao;

    /**
     * 分页获取教育经历列表数据
     * @param language
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<EducationEntity> getEducationPages(String language, int pageNo, int pageSize) {
        //定义分页参数信息
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        //获取分页数据
        return educationDao.getEducationPages(language, pageBounds);

    }

    /**
     * 根据每页显示记录数，计算教育经历总页数
     * @param language
     * @param pageSize
     * @return
     */
    public Integer getTotalPage(String language, int pageSize) {
        return countTotalPage(educationDao.getEducationsCount(language), pageSize);
    }

    /**
     * 根据语言获取所有教育经历数据列表
     * @param language
     * @return
     */
    public List<EducationEntity> getAllEducations(String language) {
        return educationDao.getAllEducations(language);
    }

    /**
     * 根据 ID 获取指定教育经历信息
     * @param id
     * @return
     */
    public EducationEntity getEducation(Long id) {
        return educationDao.getEducation(id);
    }

    /**
     * 保存教育经历数据信息
     * @param education
     */
    @Transactional
    public void saveEducation(EducationEntity education) {
        educationDao.saveEducation(education);
    }

    /**
     * 更新教育经历数据信息
     * @param education
     */
    @Transactional
    public void updateEducation(EducationEntity education) {
        educationDao.updateEducation(education);
    }

    /**
     * 删除教育经历数据信息
     * @param id
     */
    @Transactional
    public void deleteEducation(Long id) {
        educationDao.deleteEducation(id);
    }
}
