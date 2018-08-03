package com.marcello.service.impl;

import com.marcello.dao.BusinessDao;
import com.marcello.entity.Business;
import com.marcello.entity.PageBean;
import com.marcello.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/18$ 16:31$
 **/
@Service
public class BusinessServiceImpl implements BusinessService{
    @Autowired
    private BusinessDao businessDao;

    @Override
    public Business businessLogin(Business business){return businessDao.findBssByNameAndPassWord(business);}

    @Override
    public void businessRegister(Business business){businessDao.addBusiness(business);}

    @Override
    public Business findBusinessByName(String bssName){return businessDao.findBusinessByName(bssName);}

    @Override
    public Business findBusinessById(int id){return businessDao.findBusinessById(id);}

    @Override
    public int selectOccasionCount(){return businessDao.selectOccasionCount();}

    @Override
    public int selectCount(){return businessDao.selectCount();}

    @Override
    public PageBean<Business> findOccasionByPage(int occasionPage){
        HashMap<String,Object> map=new HashMap<>();
        PageBean<Business> pageBean=new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(occasionPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=businessDao.selectOccasionCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc=totalCount;
        //向上取整
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(occasionPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Business> lists=businessDao.findOccasionByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public PageBean<Business> findBssByPage(int page){
        HashMap<String,Object> map=new HashMap<>();
        PageBean<Business> pageBean=new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(page);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=businessDao.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc=totalCount;
        //向上取整
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(page-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Business> lists=businessDao.findBssByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public void passBusiness(Business business){businessDao.passBusiness(business);}

    @Override
    public void refuseBusiness(int id){businessDao.refuseBusiness(id);}

    @Override
    public void deleteBusiness(int id){businessDao.deleteBusiness(id);}
}
