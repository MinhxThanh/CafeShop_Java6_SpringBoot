package edu.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<CategoriesInProduct> categoriesInProducts;
}
