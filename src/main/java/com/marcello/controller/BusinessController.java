package com.marcello.controller;

import com.marcello.entity.Business;
import com.marcello.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/18$ 16:35$
 **/
@Controller
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    /**
     * 商户登录
     * @param username
     * @param password
     * @param mv
     * @param session
     * @return
     */
    @RequestMapping(value="/businessLogin",method= RequestMethod.POST)
    public ModelAndView BusinessLogin(String username, String password, ModelAndView mv, HttpSession session) {

        Business business=new Business();
        business.setBssName(username);
        business.setBssPwd(password);
        business=businessService.businessLogin(business);

        if(business!=null){
            session.setAttribute("business", business);
            mv.setViewName("posting");
        }else {
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        return mv;
    }

    /**
     * 商户注册
     * @param business
     * @return
     */
    @RequestMapping(value="/sign-up1",method= RequestMethod.POST)
    public ModelAndView Register(Business business) {
        ModelAndView mv=new ModelAndView();
        String bssName=business.getBssName();
        if (businessService.findBusinessByName(bssName)!=null) {
            // 添加用户
            businessService.businessRegister(business);
            mv.addObject("message","提交成功！等待审核……");
            mv.setViewName("success");
        }else {
            mv.addObject("message","该用户已存在！");
            mv.setViewName("error");
        }
        return mv;
    }

    /**
     * 分页显示临时表信息
     * @param occasionPage
     * @param model
     * @return
     */
    @RequestMapping(value = "/business-list")
    public String Business(@RequestParam(value = "occasionPage",defaultValue = "1",required = false)int occasionPage, Model model){
        model.addAttribute("occasionPage",businessService.findOccasionByPage(occasionPage));
        return "business-list";
    }

    /**
     * 显示所有商户信息
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/allbusiness-list")
    public String AllBusiness(@RequestParam(value = "page",defaultValue = "1",required = false)int page, Model model){
        model.addAttribute("page",businessService.findBssByPage(page));
        return "allbusiness-list";
    }

    /**
     * 放行商户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/passBusiness")
    public String PassBusiness(int id){
        Business business=businessService.findBusinessById(id);
        businessService.passBusiness(business);
        businessService.refuseBusiness(id);
        return "success";
    }

    /**
     * 拒绝商户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/refuseBusiness")
    public String RefuseBusiness(int id){
        businessService.refuseBusiness(id);
        return "success";
    }

    /**
     * 删除商户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteBusiness")
    public String DeleteBusiness(int id){
        businessService.deleteBusiness(id);
        return "success";
    }
}
