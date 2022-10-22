package edu.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="Content")
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();

    @Column(name="Image")
    private String image;

    @Column(name="Title")
    private String title;

    //bi-directional many-to-one association to Account
    @ManyToOne
    @JoinColumn(name="AccountId")
    private Account account;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="ProductId")
    private Product product;

    //bi-directional many-to-one association to FavoriteComment
    @JsonIgnore
    @OneToMany(mappedBy="comment")
    private List<FavoriteComment> favoriteComments;
}