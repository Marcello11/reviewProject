package com.marcello.service.impl;

import com.marcello.dao.UserDao;
import com.marcello.entity.PageBean;
import com.marcello.entity.Std;
import com.marcello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

;


/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/3/29$ 19:58$
 **/

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<Std> getUserList(Map<String,Object> map) {
        return userDao.queryStdWithMap(map);
    }

    @Override
    public int selectCount(){return userDao.selectCount(); }

    @Override
    public PageBean<Std> findByPage(int currentPage){
        HashMap<String,Object> map=new HashMap<>();
        PageBean<Std> pageBean=new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=2;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=userDao.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc=totalCount;
            //向上取整
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Std> lists=userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public int addUser(List<Std> stds){
        return userDao.passStd(stds);
    }

    @Override
    public int deleteUser(Integer[] array){
        return userDao.refuseStd(array);
    }

    @Override
    public void addStd(Std std){userDao.addStd(std);}

    @Override
    public void deleteStd(String stdNum){userDao.deleteStd(stdNum);}

    @Override
    public Std findStd(String stdNum){return userDao.findStd(stdNum);}

}
