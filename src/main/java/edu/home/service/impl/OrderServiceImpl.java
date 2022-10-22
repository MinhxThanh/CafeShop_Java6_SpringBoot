package edu.home.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.home.model.Order;
import edu.home.model.OrderDetail;
import edu.home.repository.OrderDetailRepository;
import edu.home.repository.OrderRepository;
import edu.home.service.AccountService;
import edu.home.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository dao;
    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderDetailRepository detailRepository;

    @Override
    public Order create(JsonNode orderJsonData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderJsonData, Order.class);
        order.setAccount(accountService.findByUsernameOrEmail(order.getAccount().getUsername()));
        dao.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>(){};
        List<OrderDetail> details = mapper.convertValue(orderJsonData.get("orderDetails"), type)
                .stream().peek(data -> data.setOrder(order)).collect(Collectors.toList());
        detailRepository.saveAll(details);

        return order;
    }

    @Override
    public Object findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return dao.findOrderByAccount_Username(username);
    }

    @Override
    public Order findByOrderID(Long orderID) {
        return dao.findByOrderID(orderID);
    }
}
