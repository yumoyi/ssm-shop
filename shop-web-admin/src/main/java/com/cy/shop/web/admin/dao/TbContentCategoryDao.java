package com.cy.shop.web.admin.dao;

import com.cy.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cy
 * @since 2020-09-29 15:48
 */
@Repository
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll ();
}
