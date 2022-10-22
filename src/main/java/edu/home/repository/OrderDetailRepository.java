package edu.home.repository;

import edu.home.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(Long orderId);

    @Query(value = "SELECT * from getTotalOrderDetails()", nativeQuery = true)
    List<Tuple> findTotalOrderDetails();
}