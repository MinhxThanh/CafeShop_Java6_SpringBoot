package edu.home.controller;

import edu.home.model.Account;
import edu.home.service.AccountService;
import edu.home.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "checkout")
    public String checkout(Model model, HttpServletRequest request){
//        model.addAttribute("account", accountService.findByUsernameOrEmail(request.getRemoteUser()));
        model.addAttribute("pageTitle", "Your Orders");
        return "order/checkout";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        model.addAttribute("pageTitle", "Your Orders");
        model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }

    @RequestMapping(value = "list")
    public String list(Model model, HttpServletRequest request){
        model.addAttribute("pageTitle", "Your Orders");
        model.addAttribute("orders", orderService.findByUsername(accountService.findByUsernameOrEmail(request.getRemoteUser()).getUsername()));
        return "order/list";
    }
}
