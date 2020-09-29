package com.cy.shop.web.admin.web.controller;

import com.cy.shop.commons.constant.ConstantUtils;
import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.dto.PageInfo;
import com.cy.shop.domain.TbUser;
import com.cy.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户管理
 *
 * @author cy
 * @since 2020-08-27 12:23
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;


    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser = null;

        //id不为空,从数据库中获取
        if (id!=null){
            tbUser = tbUserService.getById(id);
        }
        //id为空,创建一个空对象
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 用户列表页面跳转
     *
     * @return DataTables所需要的封装分页数据
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }


    /**
     * 表单页面跳转(新增,查看)
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 分页查询
     * @param request 请求
     * @param tbUser 带条件的用户(搜索请求)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser) {

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strDraw == null ? 0 : Integer.parseInt(strStart);
        int length = strDraw == null ? 10 : Integer.parseInt(strLength);

        PageInfo<TbUser> page = tbUserService.page(start, length, draw, tbUser);
        return page;
    }

    /**
     * 保存数据
     * @param tbUser
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser,Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);

        //保存成功
        if(baseResult.getStatus()== ConstantUtils.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else{
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    /**
     * 显示用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "user_detail";
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

}
