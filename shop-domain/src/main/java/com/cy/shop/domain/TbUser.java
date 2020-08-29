package com.cy.shop.domain;

import com.cy.shop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The type Tb user.
 *
 * @author cy
 * @since 2020 -07-04 11:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;

}
