package edu.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="Rate")
    private int rate;

    //bi-directional many-to-one association to Account
    @ManyToOne
    @JoinColumn(name="Username")
    private Account account;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="productid")
    private Product product;
}