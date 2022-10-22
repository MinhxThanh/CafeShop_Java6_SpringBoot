package edu.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Imagedescribes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDescribe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="Image")
    private String image;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="Productid")
    private Product product;

}