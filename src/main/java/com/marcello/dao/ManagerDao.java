package com.marcello.dao;

import com.marcello.entity.Manager;
import com.marcello.entity.Section;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author mcsb
 * CreateDate 2018/4/17$ 21:23$
 **/
public interface ManagerDao {
    /**
     *根据用户名和密码查找
     */
    Manager findManagerByNameAndPassword(Manager manager);

    /**
     * 部门登陆
     * @param section
     * @return
     */
    Section findSectionByNameAndPassword(Section section);

    /**
     * 查询所有部门数
     * @return
     */
    int selectCount();

    /**
     * 查询部门信息
     * @param map
     * @return
     */
    List<Section> findSectionByPage(HashMap<String, Object> map);

    /**
     * 删除部门
     * @param id
     */
    void deleteSection(int id);
}
