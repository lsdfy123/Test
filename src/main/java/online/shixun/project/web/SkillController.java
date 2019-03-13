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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import online.shixun.project.entity.SkillEntity;
import online.shixun.project.service.SkillService;
import online.shixun.project.utils.ResponseData;


/**
 * 专业技能 Controller
 */
@Controller
@RequestMapping(value = "/skill")
public class SkillController extends BaseController {

    //注入专业技能 Service
    @Autowired
    private SkillService skillService;

    /**
     * 专业技能内容
     * @param model
     * @return
     */
    @RequestMapping(value = "/content")
    public String viewMySkill(Model model) {
        List<SkillEntity> skills = skillService.getMySkills(getCurrentLanguageFromSession());
        model.addAttribute("skills", skills);
        return "/skill/content";
    }

    /**
     * 编辑专业技能
     * @param model
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String editMySkill(Model model) {
        List<SkillEntity> skills = skillService.getMySkills(getCurrentLanguageFromSession());
        //第一次编辑技能（即数据为空时）
        if (skills == null || skills.size() == 0) {
            skills = Lists.newArrayList();
            //创建 6 个空的技能实体
            for (int i = 0; i <= 6; i++) {
                skills.add(new SkillEntity());
            }
        }
        model.addAttribute("skills", skills);
        return "/skill/form";
    }

    /**
     * 保存专业技能
     * @param model
     * @param ids
     * @param names
     * @param levels
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveMySkill(Model model, @RequestParam(value = "id") Long[] ids, @RequestParam(value = "name") String[] names, @RequestParam(value = "level") Integer[] levels) {
        ResponseData response = new ResponseData();
        try {
            //当前语言环境
            String currentLanguage = getCurrentLanguageFromSession();
            for (int i = 0, n = ids.length; i < n; i++) {
                //专业技能 id=0 表示新增
                if (ids[i].longValue() == 0) {
                    skillService.saveMySkill(new SkillEntity(names[i], levels[i], i, currentLanguage));
                } else {//编辑后保存
                    skillService.updateMySkill(new SkillEntity(ids[i], names[i], levels[i], i, currentLanguage));
                }
            }
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
