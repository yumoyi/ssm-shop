package com.cy.shop.web.admin.service.impl;

import com.cy.shop.web.admin.dao.TbContentCategoryDao;
import com.cy.shop.web.admin.service.TbContentCategoryServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cy
 * @since 2020-09-29 15:50
 */

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryServie {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

}
