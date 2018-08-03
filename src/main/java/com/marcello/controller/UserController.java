package com.marcello.controller;

import com.marcello.entity.Std;
import com.marcello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/3/29$ 19:41$
 **/
@SessionAttributes("pagemsg")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param stdNum
     * @param stdSex
     * @param stdAge
     * @param stdTel
     * @return
     */
    @RequestMapping("/getUserList")
    public ModelAndView getUserList(String stdNum, String stdSex, String stdAge, String stdTel, ModelMap modelMap){
        Map<String,Object> map=new HashMap< >();
        map.put("stdNum",stdNum);
        map.put("stdSex",stdSex);
        map.put("stdAge",stdAge);
        map.put("stdTel",stdTel);
        List<Std> ls= userService.getUserList(map);
        modelMap.addAttribute("user",ls);
        return new ModelAndView("manager",modelMap);
//        return "html/manager";
    }

    /**
     * 分页查询（审核表）
     * @param currentPage
     * @param model
     * @return
     */
    @RequestMapping(value = "/student-list")
    public String manager(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage, Model model){
        model.addAttribute("pagemsg",userService.findByPage(currentPage));
        return "student-list";
    }

    /**
     * 批量添加用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(@RequestBody ArrayList<Std> stds){
        return userService.addUser(stds);
    }

    /**
     * 根据check_box选择批量删除用户
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Integer deleteUser(@RequestParam(value = "array") Integer[] array){
        if (array==null||array.length<=0){
            return 0;
        }
        return userService.deleteUser(array);
    }

    /**
     * 单个添加及删除用户
     */

//    @RequestMapping(value ="addStd",method = RequestMethod.POST)
//    public ModelAndView examine(ModelAndView mv,String action,String stdNum){
//        if (action.equals("通过")){
//            Std std1=userService.findStd(stdNum);
//            userService.addStd(std1);
//            userService.deleteStd(stdNum);
//        }
//        else if (action.equals("删除")){
//            userService.deleteStd(stdNum);
//        }
//        mv.setViewName("html/student-list");
//        return mv;
//        }

    /**
     * 添加用户
     * @param stdNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStd")
    public String addStd(String stdNum){
        Std std=userService.findStd(stdNum);
         userService.addStd(std);
         userService.deleteStd(stdNum);
         return "success";
    }

    /**
     * 删除用户
     * @param stdNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteStd")
    public String deleteStd(String stdNum){
        userService.deleteStd(stdNum);
        return "success";
    }
}
