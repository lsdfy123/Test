/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.HobbyEntity;

/**
 * 爱好Dao
 */
public interface HobbyDaoMyBatis {

    /**
     * 根据语言获取我的爱好信息
     * @param language
     * @return
     */
    public List<HobbyEntity> getMyHobbies(@Param("language") String language);

    /**
     * 保存我的爱好信息
     * @param hobby
     */
    public void saveMyHobby(HobbyEntity hobby);

    /**
     * 更新我的爱好信息
     * @param hobby
     */
    public void updateMyHobby(HobbyEntity hobby);
}
