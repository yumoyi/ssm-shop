package com.cy.shop.web.admin.dao;

import com.cy.shop.commons.persistence.BaseDao;
import com.cy.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

/**
 * @author cy
 * @since 2020-10-10 14:12
 */
@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
