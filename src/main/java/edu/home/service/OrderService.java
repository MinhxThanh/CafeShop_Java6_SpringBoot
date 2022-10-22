package edu.home.service;

import com.fasterxml.jackson.databind.JsonNode;
import edu.home.model.Order;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderJsonData);

    Object findById(Long id);

    List<Order> findByUsername(String username);

    Order findByOrderID(Long orderID);
}
