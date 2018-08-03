package com.marcello.service;

import com.marcello.entity.Business;
import com.marcello.entity.PageBean;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/18$ 16:30$
 **/
public interface BusinessService {
    /**
     * 商户登录
     * @param business
     * @return
     */
    Business businessLogin(Business business);

    /**
     * 商户注册
     * @param business
     */
    void businessRegister(Business business);

    /**
     * 根据应户名查找商户
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
     * 分页查询临时表
     * @param occasionPage
     * @return
     */
    PageBean<Business> findOccasionByPage(int occasionPage);

    /**
     * 分页查询正式表s信息
     * @param page
     * @return
     */
    PageBean<Business> findBssByPage(int page);

    /**
     * 临时表商户数
     * @return
     */
    int selectOccasionCount();

    /**
     * 正式表商户数
     * @return
     */
    int selectCount();

    /**
     * 放行商户
     * @param business
     */
    void passBusiness(Business business);

    /**
     * 拒绝商户
     * @param id
     */
    void refuseBusiness(int id);

    /**
     * 删除商户
     * @param id
     */
    void deleteBusiness(int id);
}
