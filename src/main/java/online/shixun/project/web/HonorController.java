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

import online.shixun.project.entity.HonorEntity;
import online.shixun.project.service.HonorService;
import online.shixun.project.utils.ResponseData;

/**
 * 荣誉 Controller
 */
@Controller
@RequestMapping(value = "/honor")
public class HonorController extends BaseController {

    //注入荣誉 Service
    @Autowired
    private HonorService honorService;

    /**
     * 荣誉内容
     * @param model
     * @return
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String listHonor(Model model) {
        List<HonorEntity> honors = honorService.getAllHonors(getCurrentLanguageFromSession());
        model.addAttribute("honors", honors);
        return "/honor/content";
    }

    /**
     * 荣誉管理主页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainHonor(Model model) {
        List<HonorEntity> honors = honorService.getAllHonors(getCurrentLanguageFromSession());
        model.addAttribute("honors", honors);
        return "/honor/main";
    }

    /**
     * 新增荣誉
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addHonor(Model model) {
        model.addAttribute("honor", new HonorEntity());
        return "/honor/form";
    }

    /**
     * 编辑荣誉
     * @param model
     * @param honorId
     * @return
     */
    @RequestMapping(value = "/edit/{honorId}", method = RequestMethod.GET)
    public String editHonor(Model model, @PathVariable("honorId") Long honorId) {
        HonorEntity honor = honorService.getHonor(honorId);
        model.addAttribute("honor", honor);
        return "/honor/form";
    }

    /**
     * 保存荣誉
     * @param model
     * @param honor
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveHonor(Model model, @ModelAttribute("honor") HonorEntity honor) {
        ResponseData response = new ResponseData();
        try {
            //设置当前语言环境
            honor.setLanguage(getCurrentLanguageFromSession());
            //id=0,表示新增荣誉
            if (honor.getId().longValue() == 0) {
                honorService.saveHonor(honor);
            } else {//编辑后，更新荣誉
                honorService.updateHonor(honor);
            }
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * 删除荣誉
     * @param model
     * @param honorId
     * @return
     */
    @RequestMapping(value = "/delete/{honorId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteHonor(Model model, @PathVariable("honorId") Long honorId) {
        ResponseData response = new ResponseData();
        try {
            //执行删除荣誉
            honorService.deleteHonor(honorId);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
