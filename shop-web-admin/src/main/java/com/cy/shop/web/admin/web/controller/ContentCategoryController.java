package com.cy.shop.web.admin.web.controller;

import com.cy.shop.web.admin.service.TbContentCategoryServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 内容分类管理
 * @author cy
 * @since 2020-09-29 15:52
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryServie tbContentCategoryServie;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "content_category_list";
    }


}
