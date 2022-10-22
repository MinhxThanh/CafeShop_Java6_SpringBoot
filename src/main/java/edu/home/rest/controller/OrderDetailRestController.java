package edu.home.rest.controller;

import edu.home.common.model.TotalOrderDetail;
import edu.home.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest")
public class OrderDetailRestController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping(value = "orderDetails")
    public List<TotalOrderDetail> getTotalOrderDetails(){
        return orderDetailsService.findTotalOrderDetails();
    }

    @DeleteMapping(value = "orderDetails/{id}")
    public void delete(@PathVariable("id") Integer id){
        orderDetailsService.deleteById(id);
    }
}
