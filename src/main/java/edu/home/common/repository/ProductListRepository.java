package edu.home.common.repository;

import edu.home.common.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductListRepository {
//    @Query(value = "{call get_all_product_image}", nativeQuery = true)
//    List<ProductList> findAllProductAndImageFromImageDescribes();

//    @Query("select new ProductList(p.id, p.name, p.price, i.image) from Product p " +
//            "join ImageDescribe i on i.product.id = p.id")
//    List<ProductList> findAllProductAndImageFromImageDescribes1();

}