package com.cy.shop.commons.persistence;

import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 *
 * @author cy
 * @since 2020-08-28 11:13
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询全部
     *
     * @return 查询到的全部数据
     */
    List<T> selectAll();

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    T getById(Long id);

    /**
     * 更新信息
     *
     * @param entity 需要更新的用户信息
     */
    void update(T entity);

    /**
     * 批量删除
     *
     * @param ids 用户
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param start  查询起始值
     * @param length 查询长度
     * @param draw
     * @param entity 实体类
     * @return 分页数据
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总记录数
     *
     * @param entity 查询的实体类
     * @return 总记录数
     */
    int count(T entity);
}
