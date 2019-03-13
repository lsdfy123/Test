/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.project.entity.ContactEntity;
import online.shixun.project.mapper.ContactDaoMyBatis;

/**
 * 联系我 Service
 */
@Service
public class ContactService extends BaseService {

    //注入联系我 Dao
    @Autowired
    private ContactDaoMyBatis contactDao;

    //注入邮件发送器
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 根据“姓名”，“邮件” 查询联系我数据列表
     * @param language
     * @return
     */
    public List<ContactEntity> getContacts(String name, String email) {
        return contactDao.getContacts(name, email);
    }

    /**
     * 发送联系我信息
     * @param contact
     */
    @Transactional
    public void sendContact(ContactEntity contact) {
        //发送邮件到指定邮箱
        SimpleMailMessage msg = new SimpleMailMessage();
        //TODO 收件人地址
        msg.setTo(contact.getEmail());
        //邮件主题
        msg.setSubject(contact.getName());
        //TODO 发送方邮件地址，必须与 applicationContext-email.xml 中的 name="username" 指定值一致
        msg.setFrom("1665988287@qq.com");
        //邮件内容
        msg.setText(contact.getMessage());

        //执行发送邮件
        mailSender.send(msg);

        //保存数据到数据库
        contactDao.saveContact(contact);
    }

    /**
     * 删除联系我数据信息
     * @param id
     */
    @Transactional
    public void deleteContact(Long id) {
        contactDao.deleteContact(id);
    }
}
