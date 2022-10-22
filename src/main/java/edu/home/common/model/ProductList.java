package edu.home.common.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "getProductList", procedureName = "getAllProductImage1")})
public class ProductList{
    @Id
    private Integer id;
    private String name;
    private Double price;
    private String image;

}
