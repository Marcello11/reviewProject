package com.marcello.dao;

import com.marcello.entity.Std;

import java.util.HashMap;
import java.util.List;

/**
 * @author mcsb
 */
public interface StdDao {
    /**
     *根据用户名和密码查找
     */
    Std findByStdNameAndPassword(Std std);

    /**
     * 增加用户
     * @param std
     */
    void addStd(Std std);

    /**
     * 根据应户名查找
     * @param username
     * @return
     */
    Std findByStdName(String username);

    /**
     * 查询所有用户总数
     */
    int selectCount();

    /**
     * 分页查询所有学生
     * @param map
     * @return
     */
    List<Std> findStdByPage(HashMap<String, Object> map);

    /**
     * 删除用户
     */
    void deleteStd(String stdNum);
}
