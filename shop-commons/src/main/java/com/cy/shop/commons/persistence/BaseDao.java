package com.cy.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 数据访问层的基类
 *
 * @author cy
 * @since 2020-08-28 10:37
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * 查询全部数据
     *
     * @return 全部数据
     */
    List<T> selectAll();

    /**
     * 根据id查询
     *
     * @param id 需查询数据的id
     * @return 查询数据
     */
    T getById(Long id);

    /**
     * 新增
     *
     * @param entity 新增的数据
     */
    void insert(T entity);

    /**
     * 更新
     *
     * @param entity 更新的数据
     */
    void update(T entity);

    /**
     * 删除
     *
     * @param id 需删除的id
     */
    void delete(Long id);

    /**
     * 批量删除
     *
     * @param ids 删除的id数据
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param pageParams 需要两个参数，start/记录开始的位置 length/每页记录数
     * @return 分页数据
     */
    List<T> page(Map<String, Object> pageParams);

    /**
     * 查询总记录数
     *
     * @param entity 查询所需的实体类
     * @return 总数
     */
    int count(T entity);
}
