package com.cy.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Tb user.
 *
 * @author cy
 * @since 2020 -07-04 11:39
 */
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date update;
}
