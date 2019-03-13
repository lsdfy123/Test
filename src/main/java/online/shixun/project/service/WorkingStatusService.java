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

import online.shixun.project.entity.WorkingStatusEntity;
import online.shixun.project.mapper.WorkingStatusDaoMyBatis;


/**
 * 工作状态 Service
 */
@Service
public class WorkingStatusService extends BaseService {

    //注入工作状态 Dao
    @Autowired
    private WorkingStatusDaoMyBatis workingStatusDao;

    /**
     * 根据语言获取所有工作状态数据
     * @param language
     * @return
     */
    @Cacheable(value = "workingStatusCache") //缓存工作状态数据
    public List<WorkingStatusEntity> getAllWorkingStatuss(String language) {
        return workingStatusDao.getAllWorkingStatus(language);
    }
}
