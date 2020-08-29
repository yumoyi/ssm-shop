package com.cy.shop.web.admin.dao;

import com.cy.shop.commons.persistence.BaseDao;
import com.cy.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @since 2020-07-01 17:15
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email 邮箱
     * @return 用户信息
     */
    TbUser getByEmail(String email);
}
