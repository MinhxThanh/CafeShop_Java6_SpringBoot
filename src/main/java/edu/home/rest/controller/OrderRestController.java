package edu.home.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import edu.home.common.model.MailInfoOrder;
import edu.home.model.Order;
import edu.home.service.MailerService;
import edu.home.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MailerService mailer;

    @PostMapping(value = "orders")
    public Order create(@RequestBody JsonNode orderJsonData) throws MessagingException {
        Order order = orderService.create(orderJsonData);
        System.out.println("order-email: " + order.getAccount().getEmail());
        MailInfoOrder mail = new MailInfoOrder();
        mail.setTo(order.getAccount().getEmail());
        mail.setSubject("This is order");
        mail.setOrderID(order.getId());
        System.out.println("public Order create(@RequestBody JsonNode orderJsonData): " + order.getId());
        mailer.send(mail);
        return order;
    }
}
