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
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();
    @ManyToOne @JoinColumn(name = "Username")
    private Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
