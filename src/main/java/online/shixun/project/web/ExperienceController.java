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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.project.entity.ExperienceEntity;
import online.shixun.project.service.ExperienceService;
import online.shixun.project.utils.Constants;
import online.shixun.project.utils.ResponseData;

/**
 * 工作经验 Controller
 */
@Controller
@RequestMapping(value = "/experience")
public class ExperienceController extends BaseController {

    //注入工作经验 Service
    @Autowired
    private ExperienceService experienceService;

    /**
     * 工作经验内容
     * @param model
     * @return
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String listExperience(Model model) {
        List<ExperienceEntity> experiences = experienceService.getAllExperiences(getCurrentLanguageFromSession());
        model.addAttribute("experiences", experiences);
        return "/experience/content";
    }

    /**
     * 工作经验管理主页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainExperience(Model model) {
        Integer totalPage = experienceService.getTotalPage(getCurrentLanguageFromSession(), Constants.DEFAULT_PAGE_SIZE);
        model.addAttribute("totalPage", totalPage);
        return "/experience/main";
    }

    /**
     * 工作经验列表
     * @param model
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/list/{pageNo}", method = RequestMethod.GET)
    public String listExperience(Model model, @PathVariable int pageNo) {
        //根据指定页数，获取工作经验分页数据记录
        List<ExperienceEntity> experiences = experienceService.getExperiencePages(getCurrentLanguageFromSession(), pageNo, Constants.DEFAULT_PAGE_SIZE);
        model.addAttribute("experiences", experiences);

        //将当前页数传递到前端页面
        model.addAttribute("currentPage", pageNo);

        return "/experience/list";
    }

    /**
     * 新增工作经验
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addExperience(Model model) {
        model.addAttribute("experience", new ExperienceEntity());
        return "/experience/form";
    }

    /**
     * 编辑工作经验
     * @param model
     * @param experienceId
     * @return
     */
    @RequestMapping(value = "/edit/{experienceId}", method = RequestMethod.GET)
    public String editExperience(Model model, @PathVariable("experienceId") Long experienceId) {
        ExperienceEntity experience = experienceService.getExperience(experienceId);
        model.addAttribute("experience", experience);
        return "/experience/form";
    }

    /**
     * 保存工作经验
     * @param model
     * @param experience
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveExperience(Model model, @ModelAttribute("experience") ExperienceEntity experience) {
        ResponseData response = new ResponseData();
        try {
            //设置当前语言环境
            experience.setLanguage(getCurrentLanguageFromSession());
            //id=0,表示新增工作经验
            if (experience.getId().longValue() == 0) {
                experienceService.saveExperience(experience);
            } else {//编辑后，更新工作经验
                experienceService.updateExperience(experience);
            }
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * 删除工作经验
     * @param model
     * @param experienceId
     * @return
     */
    @RequestMapping(value = "/delete/{experienceId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteExperience(Model model, @PathVariable("experienceId") Long experienceId) {
        ResponseData response = new ResponseData();
        try {
            //执行删除工作经验
            experienceService.deleteExperience(experienceId);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
