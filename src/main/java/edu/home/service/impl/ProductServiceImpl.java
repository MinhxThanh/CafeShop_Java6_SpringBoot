package edu.home.service.impl;

import edu.home.common.model.ProductList;
import edu.home.common.model.Report;
import edu.home.common.repository.ProductListRepository;
import edu.home.model.Category;
import edu.home.model.Product;
import edu.home.repository.ProductRepository;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository dao;
    @Autowired
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public Product create(Product product) {
        return dao.save(product);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductList> findAllProductAndImageFromImageDescribes() {
        return em.createNamedStoredProcedureQuery("getProductList").getResultList();
    }

    @Override
    public List<ProductList> findAllProductByCategoryName(String s) {
        List<Tuple> tuples = dao.findAllProductByCategoryName(s);
        List<ProductList> productList = tuples.stream().map(t ->new ProductList(
                t.get(0, Integer.class),
                t.get(1, String.class),
                t.get(2, Double.class),
                t.get(3, String.class)
        )).collect(Collectors.toList());
        return productList;
    }

    @Override
    public List<ProductList> findAllProductAndImageFromImageDescribesFunc() {
        List<Tuple> objects = dao.listProduct();
        List<ProductList> list = objects.stream().map(t -> new ProductList(
                t.get(0, Integer.class),
                t.get(1, String.class),
                t.get(2, Double.class),
                t.get(3, String.class)
        )).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Report> getInventoryByOderDetail() {
        List<Tuple> objects = dao.getInventoryByOderDetail();
        List<Report> list = objects.stream().map(t -> new Report(
                t.get(0, String.class),
                t.get(1, Double.class),
                t.get(2, Integer.class),
                t.get(3, Double.class)
        )).collect(Collectors.toList());
        return list;
    }
}
