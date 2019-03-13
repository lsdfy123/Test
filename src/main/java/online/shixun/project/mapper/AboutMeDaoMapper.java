package online.shixun.project.mapper;

import org.apache.ibatis.annotations.Param;

import online.shixun.project.entity.AboutMeEntity;

public interface AboutMeDaoMapper {
	
    /**
     * 根据语言获取我的基本信息
     * @param language
     * @return
     */
    public AboutMeEntity getAboutMe(@Param("language") String language);

    /**
     * 保存我的基本信息
     * @param aboutMe
     */
    public void saveAboutMe(AboutMeEntity aboutMe);

    /**
     * 更新我的基本信息
     * @param aboutMe
     */
    public void updateAboutMe(AboutMeEntity aboutMe);

    /**
     * 更新简历文件名称
     * @param resumeFile
     * @param id
     */
    public void updateResumeFile(@Param("resumeFile") String resumeFile, @Param("id") Long id);

}
