package com.marcello.service;

import com.marcello.entity.PageBean;
import com.marcello.entity.Std;

/**
 * @author nozomi
 */

public interface StdService {

    /**
     *用户登录
     */
    public Std login(Std std);

    /**
     *用户注册
     */
    public void register(Std std);

    /**
     *g根据用户名查找
     */
    public Std findByStdName(String stdname);

    /**
     * 分也查询学生表
     * @param currentPage
     * @return
     */
    PageBean<Std> findStdByPage(int currentPage);

    /**
     * 单个删除用户
     * @param
     */
    public void deleteStd(String stdNum);




}
