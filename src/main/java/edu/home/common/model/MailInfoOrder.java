package edu.home.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfoOrder {
    private String from = "mr.minhxthanh@gmail.com";
    private String to;
    private Long orderID;
    private String subject;

}