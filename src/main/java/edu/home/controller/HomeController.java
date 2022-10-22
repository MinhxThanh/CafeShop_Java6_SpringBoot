package edu.home.controller;

import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping({"/", "/home/index"})
    public String home(Model model){
        model.addAttribute("pageTitle", "Home");
        return "home/index";
    }

    @RequestMapping({"/admin", "/admin/home/index"})
    public String admin(){
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("pageTitle", "About Us");
        return "about/index";
    }

    @RequestMapping(value = "/store")
    public String store(Model model){
        model.addAttribute("pageTitle", "Store");
        return "home/store";
    }

    @RequestMapping(value = "/product-intro")
    public String intro(Model model){
        model.addAttribute("pageTitle", "Intro Product");
        return "product/intro";
    }
}
