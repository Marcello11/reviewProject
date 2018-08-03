package com.marcello.dao;

import com.marcello.entity.Business;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/18$ 16:22$
 **/


public interface BusinessDao {
    /**
     * 根据用户名和密码查询商户
     * @param business
     * @return
     */
    Business findBssByNameAndPassWord(Business business);

    /**
     * 添加商户
      * @param business
     */
    void addBusiness(Business business);

    /**
     * 根据商户名查找
     * @param bssName
     * @return
     */
    Business findBusinessByName(String bssName);

    /**
     * 根据id查找商户
     * @param id
     * @return
     */
    Business findBusinessById(int id);

    /**
     * 查询待审核用户信息
     * @param map
     * @return
     */
    List<Business> findOccasionByPage(HashMap<String, Object> map);

    /**
     * 查询所有商户信息
     * @param map
     * @return
     */
    List<Business> findBssByPage(HashMap<String, Object> map);
    /**
     * 查询待审核用户数
     * @return
     */
    int selectOccasionCount();

    /**
     * 查询商户总数
     * @return
     */
    int selectCount();

    /**
     * 添加至正式表
     * @param business
     */
    void passBusiness(Business business);

    /**
     * 从临时表删除
     * @param id
     */
    void refuseBusiness(int id);

    /**
     * 从正式表删除
     * @param id
     */
    void deleteBusiness(int id);
}
