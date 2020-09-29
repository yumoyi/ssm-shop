package com.cy.shop.web.admin.service.impl;

import com.cy.shop.domain.TbContentCategory;
import com.cy.shop.web.admin.dao.TbContentCategoryDao;
import com.cy.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @since 2020-09-29 15:50
 */

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;


    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }
}
