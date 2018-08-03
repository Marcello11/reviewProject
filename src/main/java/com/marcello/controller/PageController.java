package com.marcello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/25$ 21:35$
 **/
@Controller
@RequestMapping("/page")
public class PageController {
    /**
     * 跳转到登录界面
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/signup")
    public ModelAndView stdSignUp(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("sign-up");
        return modelAndView;
    }

    @RequestMapping("/signup1")
    public ModelAndView bssSignUp(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("sign-up1");
        return modelAndView;
    }
}
