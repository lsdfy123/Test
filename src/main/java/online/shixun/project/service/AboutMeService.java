/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import online.shixun.project.mapper.AboutMeDaoMapper;
import online.shixun.project.entity.AboutMeEntity;
import online.shixun.project.utils.Constants;


/**
 * 我的基本信息 Service
 */
@Service
public class AboutMeService extends BaseService {

    //注入基本信息Dao
    @Autowired
    private AboutMeDaoMapper aboutMeDao;

    /**
     * 根据语言获取基本信息
     * @param language
     * @return
     */
    public AboutMeEntity getAboutMe(String language) {
        return aboutMeDao.getAboutMe(language);
    }

    /**
     * 保存基本信息
     * @param aboutMe
     */
    @Transactional
    public void saveAboutMe(AboutMeEntity aboutMe) {
        aboutMeDao.saveAboutMe(aboutMe);
    }

    /**
     * 更新基本信息
     * @param aboutMe
     */
    @Transactional
    public void updateAboutMe(AboutMeEntity aboutMe) {
        aboutMeDao.updateAboutMe(aboutMe);
    }

    /**
     * 更新简历文件名称
     * @param resumeFile
     * @param id
     */
    @Transactional
    public void updateResumeFile(String resumeFile, Long id) {
        aboutMeDao.updateResumeFile(resumeFile, id);
    }

    /**
     * 保存头像文件
     * @param path
     * @param avatar
     * @throws IOException
     */
    public void saveMyAvatar(String path, MultipartFile avatar) throws IOException {
        //我的头像文件
        String avatarFileName = path + Constants.MY_AVATAR_FILE_NAME;
        File avatarFile = new File(avatarFileName);
        //利用 FileCopyUtils 工具类保存用户头像图片文件
        FileCopyUtils.copy(avatar.getBytes(), avatarFile);
    }
}
