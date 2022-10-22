package edu.home.controller;

import edu.home.common.model.ProductList;
import edu.home.model.CategoriesInProduct;
import edu.home.model.ImageDescribe;
import edu.home.model.Product;
import edu.home.model.Rate;
import edu.home.service.CategoriesInProductService;
import edu.home.service.ImageDescribeService;
import edu.home.service.ProductService;
import edu.home.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ImageDescribeService imageDescribeService;
    @Autowired
    private RateService rateService;

    @RequestMapping(value = "list")
    public String list(Model model, @RequestParam("category") Optional<String> name) {
        if (name.isPresent()) {
            System.out.println("category: " + name);
            List<ProductList> list = productService.findAllProductByCategoryName(name.get());
            model.addAttribute("items", list);
        } else {
            List<ProductList> list = productService.findAllProductAndImageFromImageDescribesFunc();
            System.out.println("List<ProductList> list" + list);
            model.addAttribute("items", list);
        }
        model.addAttribute("pageTitle", "Shop Products");
        return "product/list";
    }

    @RequestMapping(value = "detail/{id}")
    public String detail(@PathVariable("id") Optional<Integer> id, Model model) {
        if (!id.isPresent()) {
            return "redirect:/product/list";
        } else {
            Product product = productService.findById(id.get());
            List<ImageDescribe> imageDescribes = imageDescribeService.findAllImageDescribeByProductID(id.get());

            List<Rate> rates = rateService.findAllByProductId(id.get());
            int totalRate = rates.size();
            Long totalValueRate = rates.stream().mapToLong(item -> item.getRate()).sum();
            if (totalRate == 0)
                totalRate += 1;
            Double resultRate = Double.valueOf(totalValueRate / totalRate);
            System.out.println("totalValueRate: " + totalValueRate / totalRate);

            model.addAttribute("totalRate", totalRate);
            model.addAttribute("totalValueRate", resultRate);
            model.addAttribute("imageDescribes", imageDescribes);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Product Detail");
        }
        return "product/detail";
    }
}
