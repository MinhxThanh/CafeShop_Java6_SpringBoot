package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    private String name;
    private Double price;
    private Integer quantity;
    private Double totalPrice;
}