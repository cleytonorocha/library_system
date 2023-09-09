package com.github.cleyto_orocha.library_system.controllers.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenVO {
    private String userName;
    private Boolean authenticate;
    private Date created;
    private Date expiration;
    private String acessToken;
    private String refreshToken;
}
