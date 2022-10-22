package edu.home.service.impl;

import edu.home.model.CategoriesInProduct;
import edu.home.repository.CategoriesInProductRepository;
import edu.home.service.CategoriesInProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesInProductImpl implements CategoriesInProductService {
    @Autowired
    private CategoriesInProductRepository dao;

    @Override
    public void save(CategoriesInProduct categoriesInProduct) {
        dao.save(categoriesInProduct);
    }

    @Override
    public List<CategoriesInProduct> findAll() {
        return dao.findAll();
    }

    @Override
    public List<CategoriesInProduct> findByIdProduct(Integer id) {
        return dao.findByProductAndId(id);
    }

    @Override
    public Integer deleteCategoryInProductByCateIDAndProductId(Integer cid, Integer pid) {
        return dao.deleteCategoriesInProductByCategory_IdAndProduct_Id(cid, pid);
    }

    @Override
    public CategoriesInProduct findCategoriesInProductByProductIdAndCategoryId(Integer productId, Integer categoryId) {
        return dao.findByProductIdAndCategoryId(productId, categoryId);
    }
}
