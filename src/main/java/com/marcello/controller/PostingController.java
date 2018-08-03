package com.marcello.controller;

import com.marcello.entity.*;
import com.marcello.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/10$ 19:47$
 **/
@Controller
@RequestMapping("/posting")
public class PostingController {
    @Autowired
    private PostingService postingService;

    /**
     * 发布帖子
     * @param mv
     * @param posting
     * @return
     */
    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public ModelAndView publish(ModelAndView mv, Posting posting, HttpSession session, ModelMap modelMap){
        RequestAttributes ra= RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=((ServletRequestAttributes)ra).getRequest();
        session=request.getSession();
        String bssName;
        Enumeration e=session.getAttributeNames();
        /**
         * 判断发帖人的身份
         */
        while (e.hasMoreElements()) {
            String name=(String) e.nextElement();
            if (name.equals("std")) {
                Std std = (Std) session.getAttribute("std");
                bssName = std.getStdNum();
                posting.setBssName(bssName);
            } else if (name.equals("business")) {
                Business business = (Business) session.getAttribute("business");
                bssName = business.getBssName();
                posting.setBssName(bssName);
            } else if(name.equals("section")){
                Section section=(Section) session.getAttribute("section");
                bssName = section.getSectionName();
                posting.setBssName(bssName);
            } else if(name.equals("manager")){
                Manager manager=(Manager) session.getAttribute("manager");
                bssName=manager.getManagerId();
                posting.setBssName(bssName);
            }

        }
        posting.setDate(new Date());
        postingService.publishPosting(posting);
        /**
         * 手动获取帖子及列表到页面
         */
        Map<String,Object> map=new HashMap<>();
        List<Posting> ls=postingService.getPostList(map);
        modelMap.addAttribute("posting",ls);
        mv.addObject(modelMap);
        mv.setViewName("posting");
        return mv;
    }

    /**
     * 添加帖子
     * @param id
     * @return
     */
  @PostMapping(value = "/addPosting")
    public String addPosting(int id){
        Posting posting=postingService.findPostById(id);
        postingService.addPosting(posting);
        postingService.deletePosting(id);
        return "success";
    }

    /**
     * 删除帖子
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletePosting")
    public String deletePosting(int id){
        postingService.deletePosting(id);
        return "success";
    }
    /**
     * 获取帖子列表(带回复的结果集)
     * @param modelMap
     * @return
     */
    @RequestMapping("/getPosting")
    public ModelAndView getPosting(ModelMap modelMap){
        Map<String,Object> map=new HashMap< >();
        List<Posting> ls= postingService.getPostList(map);
        modelMap.addAttribute("posting",ls);
        return new ModelAndView("posting",modelMap);
    }

    /**
     * 获取待审核的帖子（仅帖子内容的结果集）
     * @param posting
     * @param modelMap
     * @return
     */
    @RequestMapping("/postOccasion")
    public ModelAndView postOccasion(Posting posting, ModelMap modelMap){
        List<Posting> list=postingService.postOccasion(posting);
        modelMap.addAttribute("postoccasion",list);
        return new ModelAndView("posting-list",modelMap);
    }

    /**
     * 发表回复
     * @param mv
     * @param reply
     * @param session
     * @return
     */
    @RequestMapping("/reply")
    public ModelAndView reply(ModelAndView mv, Reply reply, HttpSession session){
        RequestAttributes ra= RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=((ServletRequestAttributes)ra).getRequest();
        session=request.getSession();
        String name;
        Enumeration e=session.getAttributeNames();
        while (e.hasMoreElements()) {
            String user=(String) e.nextElement();
            if (user.equals("std")) {
                Std std = (Std) session.getAttribute("std");
                name = std.getStdNum();
                reply.setName(name);
            } else if (user.equals("business")) {
                Business business = (Business) session.getAttribute("business");
                name = business.getBssName();
                reply.setName(name);
            } else if(user.equals("section")){
                Section section=(Section) session.getAttribute("section");
                name = section.getSectionName();
                reply.setName(name);;
            } else if(user.equals("manager")){
                Manager manager=(Manager) session.getAttribute("manager");
                name = manager.getManagerId();
                reply.setName(name);
            }

        }
        postingService.addReply(reply);
        mv.setViewName("posting");
        return mv;
    }

    /**
     * 获取回复
     * @param modelMap
     * @return
     */
    @RequestMapping("/getReply")
    public ModelAndView getReply(int msgid, ModelMap modelMap){
        List<Reply> ls=postingService.getReply(msgid);
        modelMap.addAttribute("reply",ls);
        return new ModelAndView("posting",modelMap);
    }

    /**
     * 查找我发布的帖子
     * @param modelMap
     * @return
     */
    @RequestMapping("/myPosting")
    public ModelAndView myPosting(Posting posting, ModelMap modelMap, HttpSession session){
        RequestAttributes ra= RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=((ServletRequestAttributes)ra).getRequest();
        session=request.getSession();
        String bssName;
        Enumeration e=session.getAttributeNames();
        /**
         * 判断当前的身份
         */
        while (e.hasMoreElements()) {
            String name=(String) e.nextElement();
            if (name.equals("std")) {
                Std std = (Std) session.getAttribute("std");
                bssName = std.getStdNum();
                List<Posting> ls=postingService.myPosting(bssName);
                modelMap.addAttribute("myPosting",ls);
            } else if (name.equals("business")) {
                Business business = (Business) session.getAttribute("business");
                bssName = business.getBssName();
                List<Posting> ls=postingService.myPosting(bssName);
                modelMap.addAttribute("myPosting",ls);
            } else if(name.equals("section")){
                Section section=(Section) session.getAttribute("section");
                bssName = section.getSectionName();
                List<Posting> ls=postingService.myPosting(bssName);
                modelMap.addAttribute("myPosting",ls);
            } else if(name.equals("manager")){
                Manager manager=(Manager) session.getAttribute("manager");
                bssName=manager.getManagerId();
                List<Posting> ls=postingService.myPosting(bssName);
                modelMap.addAttribute("myPosting",ls);
            }

        }
        return new ModelAndView("myupload",modelMap);
    }

    @RequestMapping("/upload")
    public ModelAndView upload(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("upload");
        return modelAndView;
    }
}
