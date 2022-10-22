package edu.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoriesinproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesInProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name="categoriesid")
    private Category category;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="productid")
    private Product product;
}