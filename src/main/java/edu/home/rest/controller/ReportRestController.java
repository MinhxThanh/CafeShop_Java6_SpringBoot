package edu.home.rest.controller;

import edu.home.common.model.Report;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest")
public class ReportRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("report")
    public List<Report> report(){
        return productService.getInventoryByOderDetail();
    }
}
