package edu.home.service;

import edu.home.model.CategoriesInProduct;

import java.util.List;

public interface CategoriesInProductService {
    void save(CategoriesInProduct categoriesInProduct);

    List<CategoriesInProduct> findAll();

    List<CategoriesInProduct> findByIdProduct(Integer id);

    Integer deleteCategoryInProductByCateIDAndProductId(Integer cid, Integer pid);

    CategoriesInProduct findCategoriesInProductByProductIdAndCategoryId(Integer productId, Integer categoryId);
}
