package com.cy.shop.web.admin.service;

import com.cy.shop.commons.persistence.BaseService;
import com.cy.shop.domain.TbContent;

/**
 * 内容管理服务层接口
 * @author cy
 * @since 2020-10-10 14:27
 */
public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds  所需删除信息的id
     */
    void deleteByCategoryId(String[] categoryIds);
}
