/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.ContactEntity;


/**
 * 联系我Dao
 */
public interface ContactDaoMyBatis {

    /**
     * 根据语言获取我的联系我信息
     * @param language
     * @return
     */
    public List<ContactEntity> getContacts(@Param(value = "name") String name, @Param(value = "email") String email);

    /**
     * 保存我的联系我信息
     * @param contact
     */
    public void saveContact(ContactEntity contact);

    /**
     * 更新我的联系我信息
     * @param contact
     */
    public void deleteContact(@Param(value = "id") Long id);
}
