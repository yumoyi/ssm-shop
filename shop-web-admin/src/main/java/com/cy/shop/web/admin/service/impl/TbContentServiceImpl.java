package com.cy.shop.web.admin.service.impl;

import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.validator.BeanValidator;
import com.cy.shop.domain.TbContent;
import com.cy.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.cy.shop.web.admin.dao.TbContentDao;
import com.cy.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author cy
 * @since 2020-10-10 15:40
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);

        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        // 验证通过
        else {
            tbContent.setUpdated(new Date());

            // 新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }

            // 编辑内容
            else {
                update(tbContent);
            }

            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
    public void deleteByCategoryId(String[] categoryIds) {
        dao.deleteByCategoryId(categoryIds);
    }
}
