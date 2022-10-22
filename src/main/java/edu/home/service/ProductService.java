package edu.home.service;

import edu.home.common.model.ProductList;
import edu.home.common.model.Report;
import edu.home.model.Category;
import edu.home.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

    List<ProductList> findAllProductAndImageFromImageDescribes();

    List<ProductList> findAllProductByCategoryName(String s);

    List<ProductList> findAllProductAndImageFromImageDescribesFunc();

    List<Report> getInventoryByOderDetail();
}
