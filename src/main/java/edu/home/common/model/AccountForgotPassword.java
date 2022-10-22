package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountForgotPassword {
    private String username;
    private String password;
    private String passwordConfirm;
    private Long code;
}
