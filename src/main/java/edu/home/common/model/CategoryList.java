package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class CategoryList implements Serializable {
    @Id
    private Integer id;
    private String name;
    private Long totalProduct;
}
