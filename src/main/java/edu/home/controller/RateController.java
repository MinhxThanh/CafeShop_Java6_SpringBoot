package edu.home.controller;

import edu.home.model.Rate;
import edu.home.service.AccountService;
import edu.home.service.ProductService;
import edu.home.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping(value = "rate")
public class RateController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RateService rateService;

    @PostMapping(value = "create")
    public String create(Model model, @RequestParam("usernameId") String usernameId,
                         @RequestParam("productId") Integer productId,
                         @RequestParam("rating") Integer rateValue) {
        if (usernameId.isBlank())
            return "redirect:/product/list";

        Rate rate = rateService.findByAccountUsernameAndProductId(usernameId, productId);
        if (rate != null) {
            System.out.println("ID Rate: " + rate.getId());
            rateService.updateByUsernameAndProductId(rateValue, usernameId, productId);
            System.out.println("rateValue: " + rateValue);
        } else {
            System.out.println("Username1: " + usernameId);
            Rate rate1 = new Rate();
            rate1.setAccount(accountService.findByUsernameOrEmail(usernameId));
            rate1.setProduct(productService.findById(productId));
            rate1.setRate(rateValue);
            rateService.create(rate1);
        }
        return "redirect:/product/detail/" + productId;
    }
}
