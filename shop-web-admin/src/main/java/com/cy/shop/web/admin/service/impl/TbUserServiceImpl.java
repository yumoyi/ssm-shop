package com.cy.shop.web.admin.service.impl;

import com.cy.shop.commons.constant.ConstantUtils;
import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.dto.PageInfo;
import com.cy.shop.commons.utils.RegexpUtils;
import com.cy.shop.domain.TbUser;
import com.cy.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.cy.shop.web.admin.dao.TbUserDao;
import com.cy.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;


/**
 * @author cy
 * @since 2020-08-21 17:17
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {

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

    /**
     * 保存信息
     *
     * @param tbUser 需要保存的数据
     * @return 用户是否成功的信息
     */
    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);

        //通过验证
        if(baseResult.getStatus()== ConstantUtils.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());

            //新增用户
            if(tbUser.getId()==null){
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }
        }
        return baseResult;
    }


    @Override
    public BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();

        if(StringUtils.isBlank(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入!");
        }else if(!RegexpUtils.checkEmail(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱格式有误,请重新输入!");
        }else if(StringUtils.isBlank(tbUser.getPassword())){
            baseResult = BaseResult.fail("密码不能为空,请重新输入!");
        }else if(StringUtils.isBlank(tbUser.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空,请重新输入!");
        }else if(StringUtils.isBlank(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机号不能为空,请重新输入!");
        }else if(!RegexpUtils.checkPhone(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机号格式有误,请重新输入!");
        }

        return baseResult;
    }
}
