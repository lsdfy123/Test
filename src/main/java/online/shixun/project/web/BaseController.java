/*****************************************************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package online.shixun.project.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import online.shixun.project.utils.Constants;

/**
 * Controller 基类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    //注入request
    @Autowired
    protected HttpServletRequest request;

    /**
     * 获取webapp路径的地址
     * 
     * @return 
     */
    protected String getRealPath() {
        return request.getServletContext().getRealPath("/");
    }
    
   /*
    * 将当前语言环境保存到 Session 中
    */
    protected void setCurrentLanguageToSession(String currentLanguage) {
        request.getSession().setAttribute("CurrentLanguage", currentLanguage);
    }
    
    /*
     * 从session中获取语言环境
     */
    protected String getCurrentLanguageFromSession() {
        Object language = request.getSession().getAttribute("CurrentLanguage");
        //如果Session中语言值失效，则重新存入默认语言值
        if (language == null) {
            setCurrentLanguageToSession(Constants.DEFAULT_LANGUAGE);
            return Constants.DEFAULT_LANGUAGE;
        } else {
            return (String) language;
        }
    }
    /*
     * 设定语言环境
     */
    protected void setLanguage(HttpServletRequest request, HttpServletResponse response, Locale newLocal) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, newLocal);
		
	}
}
