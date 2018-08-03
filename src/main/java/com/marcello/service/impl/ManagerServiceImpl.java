package com.marcello.service.impl;

import com.marcello.dao.ManagerDao;
import com.marcello.entity.Manager;
import com.marcello.entity.PageBean;
import com.marcello.entity.Section;
import com.marcello.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 21:29$
 **/
@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager managerLogin(Manager manager){return managerDao.findManagerByNameAndPassword(manager);}

    @Override
    public Section sectionLogin(Section section){return managerDao.findSectionByNameAndPassword(section);}

    @Override
    public PageBean<Section> findSecByPage(int currentPage){
        HashMap<String,Object> map=new HashMap<>();
        PageBean<Section> pageBean=new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=managerDao.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc=totalCount;
        //向上取整
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Section> lists=managerDao.findSectionByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public void deleteSection(int id){managerDao.deleteSection(id);}



}
