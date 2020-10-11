package com.cy.shop.commons.dto;

import com.cy.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据传输对象
 * @author cy
 * @since 2020-08-28 9:19
 */

@Data
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;
}
