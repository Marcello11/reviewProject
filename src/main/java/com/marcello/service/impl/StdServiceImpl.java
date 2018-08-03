package com.marcello.service.impl;

import com.marcello.dao.StdDao;
import com.marcello.entity.PageBean;
import com.marcello.entity.Std;
import com.marcello.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StdServiceImpl implements StdService {


        @Autowired
        private StdDao stdDao;
        @Override
        // 登录,根据用户名和密码进行查询
        public Std login(Std std) {
            return stdDao.findByStdNameAndPassword(std);
        }
         @Override
        //注册,增加用户
        public void register(Std std) {
            stdDao.addStd(std);
        }
        @Override
    //根据用户名查询
        public Std findByStdName(String stdname) {

            return stdDao.findByStdName(stdname);
        }

        @Override
        public PageBean<Std> findStdByPage(int currentPage){
            HashMap<String,Object> map=new HashMap<>();
            PageBean<Std> pageBean=new PageBean<>();
            pageBean.setCurrPage(currentPage);
            int pageSize=5;
            pageBean.setPageSize(pageSize);
            int totalCount=stdDao.selectCount();
            pageBean.setTotalCount(totalCount);
            double tc=totalCount;
            Double num=Math.ceil(tc/pageSize);
            pageBean.setTotalPage(num.intValue());
            map.put("start",(currentPage-1)*pageSize);
            map.put("size",pageBean.getPageSize());
            List<Std> lists=stdDao.findStdByPage(map);
            pageBean.setLists(lists);

            return pageBean;
        }

    @Override
    public void deleteStd(String stdNum){stdDao.deleteStd(stdNum);}

}
