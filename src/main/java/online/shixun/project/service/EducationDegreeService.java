/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import online.shixun.project.entity.EducationDegreeEntity;
import online.shixun.project.mapper.EducationDegreeDaoMyBatis;


/**
 * 教育程度 Service
 */
@Service
public class EducationDegreeService extends BaseService {

    //注入教育程度 Dao
    @Autowired
    private EducationDegreeDaoMyBatis educationDegreeDao;

    /**
     * 根据语言获取所有教育程度数据
     * @param language
     * @return
     */
    @Cacheable(value = "educationDegreeCache") //缓存教育程度数据
    public List<EducationDegreeEntity> getAllEducationDegrees(String language) {
        return educationDegreeDao.getAllEducationDegrees(language);
    }
}
