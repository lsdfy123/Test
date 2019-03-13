/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.HonorEntity;


/**
 * 荣誉 Dao
 */
public interface HonorDaoMyBatis {

    /**
     * 根据语言获取所有荣誉数据列表
     * @param language
     * @return
     */
    public List<HonorEntity> getAllHonors(@Param(value = "language") String language);

    /**
     * 根据 ID 获取指定荣誉信息
     * @param id
     * @return
     */
    public HonorEntity getHonor(@Param(value = "id") Long id);

    /**
     * 保存荣誉数据信息
     * @param honor
     */
    public void saveHonor(HonorEntity honor);

    /**
     * 更新荣誉数据信息
     * @param honor
     */
    public void updateHonor(HonorEntity honor);

    /**
     * 删除荣誉数据信息
     * @param id
     */
    public void deleteHonor(@Param(value = "id") Long id);
}
