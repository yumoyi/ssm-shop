package com.cy.shop.domain;

import com.cy.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 分类管理
 * @author cy
 * @since 2020-09-29 15:35
 */

public class TbContentCategory extends BaseEntity {
    private Long patentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;

}
