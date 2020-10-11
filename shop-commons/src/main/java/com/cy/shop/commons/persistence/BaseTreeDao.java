package com.cy.shop.commons.persistence;

import java.util.List;

/**
 * 通用的树形结构接口
 * @author cy
 * @since 2020-10-11 15:24
 */
public interface BaseTreeDao<T extends BaseEntity> {
    /**
     * 查询全部数据
     */
    List<T> selectAll();

    /**
     * 新增
     */
    void insert(T entity);

    /**
     * 删除
     */
    void delete(String[] ids);

    /**
     * 根据 ID 查询信息
     */
    T getById(Long id);

    /**
     * 更新
     */
    void update(T entity);

    /**
     * 根据父级节点 ID 查询所有子节点
     */
    List<T> selectByPid(Long pid);
}
