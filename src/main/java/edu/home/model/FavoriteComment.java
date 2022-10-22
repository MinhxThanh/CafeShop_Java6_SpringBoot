package edu.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "favorite_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //bi-directional many-to-one association to Account
    @ManyToOne
    @JoinColumn(name="Username")
    private Account account;

    //bi-directional many-to-one association to Comment
    @ManyToOne
    @JoinColumn(name="CommentId")
    private Comment comment;
}