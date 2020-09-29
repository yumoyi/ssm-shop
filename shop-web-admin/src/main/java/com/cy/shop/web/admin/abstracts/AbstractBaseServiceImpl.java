package com.cy.shop.web.admin.abstracts;

import com.cy.shop.commons.dto.BaseResult;
import com.cy.shop.commons.dto.PageInfo;
import com.cy.shop.commons.persistence.BaseDao;
import com.cy.shop.commons.persistence.BaseEntity;
import com.cy.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cy
 * @since 2020-08-28 11:28
 */
public class AbstractBaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    private D dao;

    /**
     * 查询全部
     *
     * @return 查询到的全部数据
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }


    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据 ID 获取信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 更新信息
     *
     * @param entity 需要更新的用户信息
     */
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 批量删除
     *
     * @param ids 用户
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 分页查询
     *
     * @param start  查询起始值
     * @param length 查询长度
     * @param draw
     * @param entity 实体类
     * @return 分页数据
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));
        return pageInfo;
    }

    /**
     * 查询总记录数
     *
     * @param entity 查询的实体类
     * @return 总记录数
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }
}
