package com.cy.shop.web.admin.service;

import com.cy.shop.domain.TbUser;


/**
 * @author cy
 * @since 2020-08-21 17:16
 */

public interface TbUserService {
    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    TbUser login(String email, String password);

}
