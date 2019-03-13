/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import online.shixun.project.entity.AboutMeEntity;
import online.shixun.project.utils.Constants;
import online.shixun.project.utils.ResponseData;
import online.shixun.project.service.AboutMeService;

/**
 * 首页 Controller
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {

    //注入基本信息 Service
    @Autowired
    private AboutMeService aboutMeService;

    @RequestMapping(value = "/content")
    public String viewAboutMe(Model model) {
        AboutMeEntity aboutMe = aboutMeService.getAboutMe(getCurrentLanguageFromSession());
        model.addAttribute("aboutMe", aboutMe);
        //我的头像
        String avatar = Constants.MY_AVATAR_FILE_NAME + "?" + System.currentTimeMillis();
        model.addAttribute("avatar", avatar);
        return "/home/content";
    }

    /**
     * 保存头像
     * @param model
     * @param avatar
     * @return
     */
    @RequestMapping(value = "/save/avatar", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveAboutMe(Model model, MultipartFile avatar) {
        ResponseData response = new ResponseData();
        try {
            //执行保存
        	System.out.println(getRealPath());
            aboutMeService.saveMyAvatar(getRealPath() + "/images/", avatar);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
