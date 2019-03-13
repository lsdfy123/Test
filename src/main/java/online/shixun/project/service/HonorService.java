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

import online.shixun.project.entity.HonorEntity;
import online.shixun.project.mapper.HonorDaoMyBatis;


/**
 * 荣誉 Service
 */
@Service
public class HonorService extends BaseService {

    //注入荣誉 Dao
    @Autowired
    private HonorDaoMyBatis honorDao;

    /**
     * 根据语言获取所有荣誉数据列表
     * @param language
     * @return
     */
    public List<HonorEntity> getAllHonors(String language) {
        return honorDao.getAllHonors(language);
    }

    /**
     * 根据 ID 获取指定荣誉信息
     * @param id
     * @return
     */
    public HonorEntity getHonor(Long id) {
        return honorDao.getHonor(id);
    }

    /**
     * 保存荣誉数据信息
     * @param honor
     */
    @Transactional
    public void saveHonor(HonorEntity honor) {
        honorDao.saveHonor(honor);
    }

    /**
     * 更新荣誉数据信息
     * @param honor
     */
    @Transactional
    public void updateHonor(HonorEntity honor) {
        honorDao.updateHonor(honor);
    }

    /**
     * 删除荣誉数据信息
     * @param id
     */
    @Transactional
    public void deleteHonor(Long id) {
        honorDao.deleteHonor(id);
    }
}
