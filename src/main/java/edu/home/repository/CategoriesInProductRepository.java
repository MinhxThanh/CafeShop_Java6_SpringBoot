package edu.home.repository;

import edu.home.model.CategoriesInProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoriesInProductRepository extends JpaRepository<CategoriesInProduct, Integer> {
    @Query("select c from CategoriesInProduct c where c.product.id = ?1")
    List<CategoriesInProduct> findByProductAndId(int id);

    @Query("select c from CategoriesInProduct c where c.product.id = ?1 and c.category.id = ?2")
    CategoriesInProduct findByProductIdAndCategoryId(Integer productID, Integer categoryId);

    @Transactional
    @Modifying
    @Query("delete from CategoriesInProduct c where c.category.id = ?1 and c.product.id = ?2")
    Integer deleteCategoriesInProductByCategory_IdAndProduct_Id(Integer cateID, Integer pId);
}