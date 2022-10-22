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
@Table(name = "accounts")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Account implements Serializable {
    @Id
    @Column(name="Username")
    private String username;

    @Column(name="Address")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();

    @Column(name="Email")
    private String email;

    @Column(name="Fullname")
    private String fullname;

    @Column(name="Password")
    private String password;

    @Column(name="Photo")
    private String photo;

    //bi-directional many-to-one association to Authority
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private List<Authoritie> authorities;

    //bi-directional many-to-one association to Comment
    @JsonIgnore
    @OneToMany(mappedBy="account")
    private List<Comment> comments;

    //bi-directional many-to-one association to Favorite
    @JsonIgnore
    @OneToMany(mappedBy="account")
    private List<Favorite> favorites;

    //bi-directional many-to-one association to FavoriteComment
    @JsonIgnore
    @OneToMany(mappedBy="account")
    private List<FavoriteComment> favoriteComments;

    //bi-directional many-to-one association to Order
    @JsonIgnore
    @OneToMany(mappedBy="account")
    private List<Order> orders;

    //bi-directional many-to-one association to Rate
    @JsonIgnore
    @OneToMany(mappedBy="account")
    private List<Rate> rates;
}