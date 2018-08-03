package com.marcello.controller;

import com.marcello.entity.Std;
import com.marcello.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * @author nozomi
 */
@Controller
@SessionAttributes(value = {"std"},types = {Std.class})
@RequestMapping("/std")
public class StdController {
    //注入userService
    /**
     *
     */
    @Autowired
    private StdService stdService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session) {

        Std std=new Std();
        std.setStdNum(username);
        std.setStdPwd(password);
        std=stdService.login(std);

    if(std!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("std", std);
            //转发到main请求
            mv.setViewName("posting");
        }else {
            //登录失败，设置失败信息，并调转到登录页面

            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        return mv;
    }

    /**
     * 跳转到用户注册页面
     */
    @RequestMapping(value="/register")
    public String registerpage() {

        return "sign-up";
    }
    /**
     * 用户注册
     */
    @RequestMapping(value="/sign-up",method= RequestMethod.POST)
    public ModelAndView register(Std std) {
        String stdname=std.getStdNum();
        // 如果数据库中没有该用户，可以注册，否则跳转页面
        ModelAndView mv=new ModelAndView();
        if (stdService.findByStdName(stdname) == null) {
            // 添加用户
            stdService.register(std);
            mv.addObject("message","提交成功！等待审核……");
            mv.setViewName("success");
        }else {
            mv.addObject("message","该用户已存在！");
            mv.setViewName("error");
        }
        return mv;
    }

    /**
     * 分页查询（正式表）
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping(value = "/allstudent-list")
    public String manager(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage, Model model){
        model.addAttribute("pagemsg",stdService.findStdByPage(currentPage));
        return "allstudent-list";
    }

    /**
     * 删除用户
     * @param stdNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteStd")
    public String deleteStd(String stdNum){
        stdService.deleteStd(stdNum);
        return "success";
    }
}
