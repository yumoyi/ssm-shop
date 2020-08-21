package com.cy.shop.web.admin.web.controller;

import com.cy.shop.commons.constant.ConstantUtils;
import com.cy.shop.domain.TbUser;
import com.cy.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录
 *
 * @author cy
 * @since 2020-08-21 17:19
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;


    /**
     * 跳转登录页面
     *
     * @return 登录界面
     */
    @RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑
     *
     * @param email    邮箱
     * @param password 密码
     * @return 登陆成功:后台主界面;
     * 登录失败:登录界面
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password,
                        Model model, HttpServletRequest httpServletRequest) {
        //根据邮箱和密码查找用户是否存在
        TbUser tbUser = tbUserService.login(email, password);


        // 登录失败
        if (tbUser == null) {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            model.addAttribute("email", email);
            return "login";
        }

        // 登录成功
        else {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     *
     * @param httpServletRequest
     * @return 登录界面
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        //清除session
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
