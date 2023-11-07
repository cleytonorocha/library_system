package com.github.cleyto_orocha.library_system.controllers.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentialsVO {
    private String login;
    private String password;
}
