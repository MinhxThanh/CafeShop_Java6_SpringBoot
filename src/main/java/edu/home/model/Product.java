package edu.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @Column(name="Description")
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();

    private Boolean available;

    //bi-directional many-to-one association to CategoriesInProduct
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<CategoriesInProduct> categoriesInProducts;

    //bi-directional many-to-one association to Comment
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<Comment> comments;

    //bi-directional many-to-one association to Favorite
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<Favorite> favorites;

    //bi-directional many-to-one association to ImageDescribe
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<ImageDescribe> imageDescribes;

    //bi-directional many-to-one association to OrderDetail
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    //bi-directional many-to-one association to Rate
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<Rate> rates;

    @PrePersist
    public void prePersist(){
        createDate = new Date();
    }
}
