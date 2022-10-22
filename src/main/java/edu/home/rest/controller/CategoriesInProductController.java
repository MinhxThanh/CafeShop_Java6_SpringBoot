package edu.home.rest.controller;

import edu.home.model.CategoriesInProduct;
import edu.home.model.Product;
import edu.home.service.CategoriesInProductService;
import edu.home.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class CategoriesInProductController {
    @Autowired
    private CategoriesInProductService categoriesInProductService;

    @GetMapping(value = "categoriesInProduct")
    public List<CategoriesInProduct> getAll(){
        return categoriesInProductService.findAll();
    }

    @GetMapping(value = "categoriesInProduct/{id}")
    public List<CategoriesInProduct> getByID(@PathVariable("id") Integer id){
        System.out.println("rest id: " + id);
        return categoriesInProductService.findByIdProduct(id);
    }

    @GetMapping(value ="categoriesInProduct/{cid}/{pid}")
    public CategoriesInProduct getCategoriesInProductByProductIdAndCategoryId(
            @PathVariable("cid") Integer categoryId,
            @PathVariable("pid") Integer productId){
        return categoriesInProductService.findCategoriesInProductByProductIdAndCategoryId(productId, categoryId);
    }

    @PostMapping(value = "categoriesInProduct")
    public CategoriesInProduct create(@RequestBody CategoriesInProduct categoriesInProduct){
        categoriesInProductService.save(categoriesInProduct);
        return categoriesInProduct;
    }

    @DeleteMapping(value = "categoriesInProduct/{cid}/{pid}")
    public Integer delete(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid){
        System.out.println("delete categoriesInProduct: " + cid + " and product: " + pid);
//        categoriesInProductService.deleteCategoryInProductByCateIDAndProductId(cid, pid);
        return categoriesInProductService.deleteCategoryInProductByCateIDAndProductId(cid, pid);
    }
}
