/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package online.shixun.project.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import online.shixun.project.entity.AboutMeEntity;
import online.shixun.project.service.AboutMeService;
import online.shixun.project.utils.Constants;
import online.shixun.project.utils.ResponseData;


/**
 * 下载简历 Controller
 */
@Controller
@RequestMapping(value = "/download")
public class DownloadController extends BaseController {

    @Autowired
    private AboutMeService aboutMeService;

    /**
     * 下载简历内容
     * @param model  对应下载的控制器呢？ 这个不是吗。。这个是渲染页面的 
     * @return
     */
    @RequestMapping(value = "/content")
    public String viewContact(Model model) {
        AboutMeEntity aboutMe = aboutMeService.getAboutMe(getCurrentLanguageFromSession());
        model.addAttribute("aboutMe", aboutMe);
        return "/download/content";
    }

    /**
     * 上传简历页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/form")
    public String form(Model model) {
        AboutMeEntity aboutMe = aboutMeService.getAboutMe(getCurrentLanguageFromSession());
        model.addAttribute("aboutMe", aboutMe);
        return "/download/form";
    }

    /**
     * 执行上传简历文件
     * @param model
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadResume(Model model, @RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, MultipartFile file) {
        ResponseData response = new ResponseData();
        try {
            //原始文件名称
            String originalFileName = file.getOriginalFilename();
            //文件扩展名（后缀）
            String prefixName = originalFileName.substring(originalFileName.lastIndexOf("."));

            //上传简历完整路径/文件
            String resumeFileName = Constants.MY_RESUME_FILE_DIR + "/" + name + Constants.MY_RESUME_FILE_NAME + "_" + getCurrentLanguageFromSession() + prefixName;

            File resumeFile = new File(getRealPath() + resumeFileName);
            File dir = resumeFile.getParentFile();
            //如果目录不存在，则创建之
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //保存简历文件
            FileCopyUtils.copy(file.getBytes(), resumeFile);

            //更新数据库中简历文件名称
            aboutMeService.updateResumeFile(resumeFileName, id);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }

}
