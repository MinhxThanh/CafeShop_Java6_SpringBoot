package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Register {
    @Id
    private String username;
    private String email;
    private String password;
    private String passwordConfirm;
}
