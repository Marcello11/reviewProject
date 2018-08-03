package com.marcello.service;

import com.marcello.entity.PageBean;
import com.marcello.entity.Std;

import java.util.List;
import java.util.Map;


/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/3/29$ 19:43$
 **/
public interface UserService {
    /**
     * 获取用户
     * @param map
     */
    public List<Std> getUserList(Map<String, Object> map);

    /**
     * 查询用户总数
     * @return
     */
    int selectCount();

    /**
     * 分页查询
     * @param currentPage
     * @return
     */
    PageBean<Std> findByPage(int currentPage);

    /**
     * 添加用户
     * @param stds
     * @return
     */
    public int addUser(List<Std> stds);

    /**
     *删除用户
     * @param array
     * @return
     */
    public int deleteUser(Integer[] array);

    /**
     * d单个添加用户
     * @param std
     */
    public void addStd(Std std);

    /**
     * 单个删除用户
     * @param
     */
    public void deleteStd(String stdNum);
    /**
     * 查询单个用户
     */
    public Std findStd(String stdNum);
}
