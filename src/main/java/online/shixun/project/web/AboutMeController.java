/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.project.entity.AboutMeEntity;
import online.shixun.project.entity.EducationDegreeEntity;
import online.shixun.project.entity.WorkingStatusEntity;
import online.shixun.project.service.AboutMeService;
import online.shixun.project.service.EducationDegreeService;
import online.shixun.project.service.WorkingStatusService;
import online.shixun.project.utils.ResponseData;

/**
 * 我的基本信息 Controller
 */
@Controller
@RequestMapping(value = "/about")
public class AboutMeController extends BaseController {

    //注入基本信息 Service
    @Autowired
    private AboutMeService aboutMeService;

    //注入教育程度 Service
    @Autowired
    private EducationDegreeService educationDegreeService;

    //注入工作状态 Service
    @Autowired
    private WorkingStatusService workingStatusService;

    @RequestMapping(value = "/content")
    public String viewAboutMe(Model model) {
        AboutMeEntity aboutMe = aboutMeService.getAboutMe(getCurrentLanguageFromSession());
        model.addAttribute("aboutMe", aboutMe);
        return "/about/content";
    }

    /**
     * 编辑我的基本信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/form")
    public String editAboutMe(Model model) {
        //当前语言环境
        String currentLanguage = getCurrentLanguageFromSession();
        AboutMeEntity aboutMe = aboutMeService.getAboutMe(currentLanguage);
        //第一次编辑时基本信息为空，则创建一个新的实体类
        if (aboutMe == null) {
            aboutMe = new AboutMeEntity();
        }
        //教育程度列表
        List<EducationDegreeEntity> educationDegrees = educationDegreeService.getAllEducationDegrees(currentLanguage);
        //工作状态列表
        List<WorkingStatusEntity> workingStatus = workingStatusService.getAllWorkingStatuss(currentLanguage);
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("workingStatus", workingStatus);
        //将我的基本信息传到前端页面
        model.addAttribute("aboutMe", aboutMe);
        return "/about/form";
    }

    /**
     * 保存我的基本信息
     * @param model
     * @param aboutMe
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveAboutMe(Model model, @ModelAttribute("aboutMe") AboutMeEntity aboutMe) {
        ResponseData response = new ResponseData();
        try {
            //设置语言环境
            aboutMe.setLanguage(getCurrentLanguageFromSession());
            //第一次保存为新增
            if (aboutMe.getId().longValue() == 0) {
                aboutMeService.saveAboutMe(aboutMe);
            } else {//再次编辑后更新
                aboutMeService.updateAboutMe(aboutMe);
            }
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
