package edu.home.repository;

import edu.home.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrderByAccount_Username(String name);

    @Query("select o from Order o where o.id = ?1")
    Order findByOrderID(Long id);
}