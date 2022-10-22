package edu.home.repository;

import edu.home.common.model.ProductList;
import edu.home.common.model.Report;
import edu.home.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from getAllProductImageFunc()", nativeQuery = true)
    List<Tuple> listProduct();

    @Query(value = "{call getAllProductImageByCategory(:categoryName)}", nativeQuery = true)
    List<Tuple> findAllProductByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "select * from getReport()", nativeQuery = true)
    List<Tuple> getInventoryByOderDetail();
}