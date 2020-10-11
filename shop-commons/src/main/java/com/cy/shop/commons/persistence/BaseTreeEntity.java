package com.cy.shop.commons.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 树形实体类的基类
 * @author cy
 * @since 2020-10-11 15:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
