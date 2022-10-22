package edu.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Authoritie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;
}