package edu.home.rest.controller;

import edu.home.model.Rate;
import edu.home.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class RateRestController {
    @Autowired
    private RateService rateService;

    @GetMapping(value = "rate/{productId}")
    public List<Rate> getAllByProductId(@PathVariable("productId") Integer productId){
        return rateService.findAllByProductId(productId);
    }
}
