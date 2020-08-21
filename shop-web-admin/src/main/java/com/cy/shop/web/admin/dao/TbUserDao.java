package com.cy.shop.web.admin.dao;

import com.cy.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cy
 * @since 2020-07-01 17:15
 */
@Repository
public interface TbUserDao {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email 邮箱
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<TbUser> selectAll();
}
