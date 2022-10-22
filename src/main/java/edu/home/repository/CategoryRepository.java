package edu.home.repository;

import edu.home.common.model.CategoryList;
import edu.home.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c join CategoriesInProduct cp on cp.category.id = c.id " +
            "join Product p on p.id = cp.product.id where p.id = ?1")
    List<Category> findAllCategoriesByProductId(Integer id);

    @Query("select new CategoryList (c.id, c.name, count(cp.product.id)) from Category c" +
            " left join CategoriesInProduct cp on cp.category.id = c.id " +
            "group by c.id, c.name")
    List<CategoryList> findAllCategoriesAndTotalProduct();
}