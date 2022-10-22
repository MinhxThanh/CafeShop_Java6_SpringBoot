package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class TotalOrderDetail {
    @Id
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private String username;
    private String productName;
    private Double price;
    private Integer quantity;
    private Double totalPrice;
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();
    private String address;
}
