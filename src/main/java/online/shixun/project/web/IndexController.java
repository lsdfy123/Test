package online.shixun.project.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import online.shixun.project.utils.Constants;

/**
 * 简历主页面 Controller
 */
@Controller
public class IndexController extends BaseController {

    /**
     * 进入主页面的方法，项目运行后访问根路径调用
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 获取输入的语言参数
        String language = request.getParameter("lang");
        // 未选择语言时，设置默认语言环境
        if (StringUtils.isBlank(language)) {
            language = Constants.DEFAULT_LANGUAGE;
        }
        // 将当前语言环境保存到 Session 中
        setCurrentLanguageToSession(language);
        logger.debug("当前语言:" + language);
        // language形式为 zh_CN 以下从language中获取语言编码和国家编码，即：zh 和 CN
        String[] langs = language.split("_");
        // 设置指定语言 new Locale(语言编码, 国家编码);
        Locale local = new Locale(langs[0], langs[1]);
        // 设置国际化语言
        setLanguage(request, response, local);
        // 放入model，可让视图页面获取语言信息
        model.addAttribute("language", language);
        // 转向（forward）前端页面，文件：/WEB-INF/views/index.html
        return "/index";
    }

}