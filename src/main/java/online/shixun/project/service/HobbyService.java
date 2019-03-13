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

import online.shixun.project.entity.HobbyEntity;
import online.shixun.project.mapper.HobbyDaoMyBatis;

/**
 * 爱好 Service
 */
@Service
public class HobbyService extends BaseService {

    //注入爱好 Dao
    @Autowired
    private HobbyDaoMyBatis hobbyDao;

    /**
     * 根据语言获取爱好列表
     * @param language
     * @return
     */
    public List<HobbyEntity> getMyHobbys(String language) {
        return hobbyDao.getMyHobbies(language);
    }

    /**
     * 保存爱好
     * @param hobby
     */
    @Transactional
    public void saveMyHobby(HobbyEntity hobby) {
        hobbyDao.saveMyHobby(hobby);
    }

    /**
     * 更新爱好
     * @param hobby
     */
    @Transactional
    public void updateMyHobby(HobbyEntity hobby) {
        hobbyDao.updateMyHobby(hobby);
    }
}
