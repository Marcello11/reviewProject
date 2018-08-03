package com.marcello.dao;

import com.marcello.entity.Std;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/3/29$ 20:01$
 **/
public interface UserDao {
    /**
     * 获取用户列表
     */
    List<Std> queryStdWithMap(Map<String, Object> map);
    /**
     * 查询所有用户总数
     */
    int selectCount();
    /**
     * 使用limit方法分页
     */
    List<Std> findByPage(HashMap<String, Object> map);
    /**
     * 放行用户(批量)
     */
    int passStd(List<Std> stds);
    /**
     * 拒绝用户（批量）
     */
    int refuseStd(Integer[] array);
    /**
     * 放行用户（单个）
     */
    void addStd(Std std);
    /**
     * 删除用户
     */
    void deleteStd(String stdNum);
    /**
     * 单个查询
     */
    Std findStd(String stdNum);


}


