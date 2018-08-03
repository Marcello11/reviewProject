package com.marcello.service;

import com.marcello.entity.Manager;
import com.marcello.entity.PageBean;
import com.marcello.entity.Section;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 21:28$
 **/
public interface ManagerService {
    /**
     * 管理员登录
     * @param manager
     * @return
     */
    Manager managerLogin(Manager manager);

    /**
     * 部门登陆
     * @param section
     * @return
     */
    Section sectionLogin(Section section);

    /**
     * 查询部门信息
     * @param currentPage
     * @return
     */
    PageBean<Section> findSecByPage(int currentPage);

    /**
     * 删除部门
     * @param id
     *
     */
    void deleteSection(int id);
}
