package edu.home.service.impl;

import edu.home.common.model.TotalOrderDetail;
import edu.home.model.OrderDetail;
import edu.home.repository.OrderDetailRepository;
import edu.home.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailRepository dao;
    @Override
    public List<OrderDetail> findByOrderId(Long orderID) {
        return dao.findByOrderId(orderID);
    }

    @Override
    public List<TotalOrderDetail> findTotalOrderDetails() {
        List<Tuple> tuples = dao.findTotalOrderDetails();
        List<TotalOrderDetail> totalOrderDetails = tuples.stream().map(t -> new TotalOrderDetail(
                t.get(0, Integer.class),
                t.get(1, Integer.class),
                t.get(2, Integer.class),
                t.get(3, String.class),
                t.get(4, String.class),
                t.get(5, Double.class),
                t.get(6, Integer.class),
                t.get(7, Double.class),
                t.get(8, Date.class),
                t.get(9, String.class)
        )).collect(Collectors.toList());
        return totalOrderDetails;
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id.longValue());
    }
}
