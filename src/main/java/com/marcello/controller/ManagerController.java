package com.marcello.controller;

import com.marcello.entity.Manager;
import com.marcello.entity.Section;
import com.marcello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 21:23$
 **/
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @param mv
     * @param session
     * @return
     */
    @RequestMapping(value="/managerLogin",method= RequestMethod.POST)
    public ModelAndView ManagerLogin(String username, String password, ModelAndView mv, HttpSession session) {

        Manager manager=new Manager();
        manager.setManagerId(username);
        manager.setManagerPwd(password);
        manager=managerService.managerLogin(manager);

        if(manager!=null){
            session.setAttribute("manager", manager);
            mv.setViewName("student-list");
        }else {
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        return mv;
    }

    @RequestMapping(value="/sectionLogin",method= RequestMethod.POST)
    public ModelAndView sectionLogin(String username, String password, ModelAndView mv, HttpSession session) {

        Section section=new Section();
        section.setSectionName(username);
        section.setSectionPwd(password);
        section=managerService.sectionLogin(section);

        if(section!=null){
            session.setAttribute("section", section);
            mv.setViewName("posting");
        }else {
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("error");
        }
        return mv;
    }

    /**
     * 显示部门信息
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping(value = "/allsection-list")
    public String Business(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage, Model model){
        model.addAttribute("pagemsg",managerService.findSecByPage(currentPage));
        return "allsection-list";
    }

    @RequestMapping(value = "deleteSection")
    public String DeleteSection(int id){
        managerService.deleteSection(id);
        return "success";
    }
}
