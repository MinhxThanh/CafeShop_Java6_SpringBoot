package edu.home.service;

import edu.home.common.model.TotalOrderDetail;
import edu.home.model.OrderDetail;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetail> findByOrderId(Long orderID);

    List<TotalOrderDetail> findTotalOrderDetails();

    void deleteById(Integer id);
}
