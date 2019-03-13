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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.project.entity.ContactEntity;
import online.shixun.project.service.ContactService;
import online.shixun.project.utils.ResponseData;


/**
 * 联系我 Controller
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController extends BaseController {

    //注入联系我 Service
    @Autowired
    private ContactService contactService;

    /**
     * 联系我内容
     * @param model
     * @return
     */
    @RequestMapping(value = "/content")
    public String viewContact(Model model) {
        return "/contact/content";
    }

    @RequestMapping(value = "/main")
    public String mainContact(Model model) {
        return "/contact/main";
    }

    /**
     * 联系我数据列表
     * @param model
     * @param name
     * @param email
     * @return
     */
    @RequestMapping(value = "/list")
    public String listContact(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) {
        List<ContactEntity> contacts = contactService.getContacts(name, email);
        model.addAttribute("contacts", contacts);
        return "/contact/list";
    }

    /**
     * 发送联系我信息
     * @param model
     * @param contact
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData sendContact(Model model, ContactEntity contact) {
        ResponseData response = new ResponseData();
        try {
            //执行删除
            contactService.sendContact(contact);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * 删除联系我信息
     * @param model
     * @param contactId
     * @return
     */
    @RequestMapping(value = "/delete/{contactId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseData deleteContact(Model model, @PathVariable("contactId") Long contactId) {
        ResponseData response = new ResponseData();
        try {
            //执行删除
            contactService.deleteContact(contactId);
        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            response.setError(e.getMessage());
        }
        return response;
    }
}
