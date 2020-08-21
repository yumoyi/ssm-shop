package com.cy.shop.web.admin.service.impl;

import com.cy.shop.domain.TbUser;
import com.cy.shop.web.admin.dao.TbUserDao;
import com.cy.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


/**
 * @author cy
 * @since 2020-08-21 17:17
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    /**
     * 用户登录
     *
     * @param email 邮箱
     * @return 用户信息
     */
    @Override
    public TbUser login(String email, String password) {
        //先根据email查询用户
        TbUser tbUserByEmail = tbUserDao.getByEmail(email);
        if (tbUserByEmail != null) {
            //明文加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //输入的密码与用户的密码校对,一致则返回该用户信息
            if (md5Password.equals(tbUserByEmail.getPassword())) {
                return tbUserByEmail;
            }
        }
        return null;
    }

}
