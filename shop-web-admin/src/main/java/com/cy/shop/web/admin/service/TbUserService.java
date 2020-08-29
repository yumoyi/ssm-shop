package com.cy.shop.web.admin.service;

import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.persistence.BaseService;
import com.cy.shop.domain.TbUser;

/**
 * @author cy
 * @since 2020-08-21 17:16
 */

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    TbUser login(String email, String password);

    /**
     * 保存信息
     *
     * @param tbUser 需要保存的数据
     * @return 用户是否成功的信息
     */
    BaseResult save(TbUser tbUser);

    /**
     * 用户信息有校验证
     * @param tbUser 用户
     * @return
     */
    BaseResult checkTbUser (TbUser tbUser);



}
