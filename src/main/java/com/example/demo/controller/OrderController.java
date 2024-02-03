package com.example.demo.controller;

import com.example.demo.exception.StockNameNotFound;
import com.example.demo.model.Orders;
import com.example.demo.model.Responses;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addNewOrder")
    public Responses addNewOrder(@RequestBody Orders orders) throws StockNameNotFound {
        if (orders.getCustomer().getCustomerId() == 0 || orders.getQuantity() == 0 ||
                orders.getStock().get(0).getProductName().equals("")) {
            log.error("error encountered ");
            throw new StockNameNotFound("fields can't be empty");
        }
        this.orderService.addNewOrder(orders);
        log.info("save successfully " + orders.getOrderId());
        ResponseEntity<Orders> responseEntity = new ResponseEntity<Orders>(orders, HttpStatus.CREATED);
        return new Responses("success", responseEntity);
    }


    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getOrders() throws StockNameNotFound {
        List<Orders> orders = this.orderService.getOrders();
        if (orders.isEmpty()) {
            log.error("Error");
            throw new StockNameNotFound("List is empty");
        }
        log.info("Data retrived");
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}

