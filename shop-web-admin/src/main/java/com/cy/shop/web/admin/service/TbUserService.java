package com.cy.shop.web.admin.service;

import com.cy.shop.commons.persistence.BaseService;
import com.cy.shop.domain.TbUser;

/**
 * 用户管理服务层接口
 * @author cy
 * @since 2020-08-21 17:16
 */

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     */
    TbUser login(String email, String password);
}
