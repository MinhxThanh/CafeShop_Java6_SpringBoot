package edu.home.rest.controller;

import edu.home.common.model.CategoryList;
import edu.home.model.Category;
import edu.home.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "categories")
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "categories/getAllCategoriesAndTotalProduct")
    public List<CategoryList> getAllCategoriesAndTotalProduct(){return categoryService.findAllCategoriesAndTotalProduct();}

    @GetMapping(value = "categories/getAllCategoriesByProductID/{id}")
    public List<Category> getAllCategoriesByProductID(@PathVariable("id") Integer id) {
        return categoryService.findAllCategoriesByProductID(id);
    }

    @PostMapping(value = "categories")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping(value = "categories")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping(value = "categories/{id}")
    public void delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
    }
}
