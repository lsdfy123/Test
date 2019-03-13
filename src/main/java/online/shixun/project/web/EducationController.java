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

import online.shixun.project.entity.EducationEntity;
import online.shixun.project.service.EducationService;
import online.shixun.project.utils.Constants;
import online.shixun.project.utils.ResponseData;


/**
 * 教育经历 Controller
 */
@Controller
@RequestMapping(value = "/education")
public class EducationController extends BaseController {

    //注入教育经历 Service
    @Autowired
    private EducationService educationService;

    /**
     * 教育经历内容
     * @param model
     * @return
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String listEducation(Model model) {
        List<EducationEntity> educations = educationService.getAllEducations(getCurrentLanguageFromSession());
        model.addAttribute("educations", educations);
        return "/education/content";
    }

    /**
     * 教育经历管理主页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainEducation(Model model) {
        Integer totalPage = educationService.getTotalPage(getCurrentLanguageFromSession(), Constants.DEFAULT_PAGE_SIZE);
        model.addAttribute("totalPage", totalPage);
        return "/education/main";
    }

    /**
     * 教育经历列表
     * @param model
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/list/{pageNo}", method = RequestMethod.GET)
    public String listEducation(Model model, @PathVariable int pageNo) {
        //根据指定页数，获取教育经历分页数据记录
        List<EducationEntity> educations = educationService.getEducationPages(getCurrentLanguageFromSession(), pageNo, Constants.DEFAULT_PAGE_SIZE);
        model.addAttribute("educations", educations);

        //将当前页数传递到前端页面
        model.addAttribute("currentPage", pageNo);

        return "/education/list";
    }

    /**
     * 新增教育经历
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEducation(Model model) {
        model.addAttribute("education", new EducationEntity());
        return "/education/form";
    }

    /**
     * 编辑教育经历
     * @param model
     * @param educationId
     * @return
     */
    @RequestMapping(value = "/edit/{educationId}", method = RequestMethod.GET)
    public String editEducation(Model model, @PathVariable("educationId") Long educationId) {
        EducationEntity education = educationService.getEducation(educationId);
        model.addAttribute("education", education);
        return "/education/form";
    }

    /**
     * 保存教育经历
     * @param model
     * @param education
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveEducation(Model model, @ModelAttribute("education") EducationEntity education) {
        ResponseData response = new ResponseData();
        try {
            //设置当前语言环境
            education.setLanguage(getCurrentLanguageFromSession());
            //id=0,表示新增教育经历
            if (education.getId().longValue() == 0) {
                educationService.saveEducation(education);
            } else {//编辑后，更新教育经历
                educationService.updateEducation(education);
            }
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * 删除教育经历
     * @param model
     * @param educationId
     * @return
     */
    @RequestMapping(value = "/delete/{educationId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteEducation(Model model, @PathVariable("educationId") Long educationId) {
        ResponseData response = new ResponseData();
        try {
            //执行删除教育经历
            educationService.deleteEducation(educationId);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
