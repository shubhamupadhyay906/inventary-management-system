package com.example.demo.controller;

import com.example.demo.exception.CustomerNameNotFound;
import com.example.demo.model.Customer;
import com.example.demo.model.Responses;
import com.example.demo.service.CustomerService;
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
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public Responses addNewCustomer(@RequestBody Customer customer) throws CustomerNameNotFound {
        if (customer.getPhoneNumber().equals("") || customer.getAddress().equals("")
                || customer.getName() == null || customer.getName().equals("")) {
            throw new CustomerNameNotFound("fields can't be empty");
        }
        log.info("save successfully" + customer.getName());
        this.customerService.addNewCustomer(customer);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
        return new Responses("success", responseEntity);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> cus = this.customerService.getCustomer();
        log.info("Data retrived");
        return new ResponseEntity<>(cus, HttpStatus.OK);
    }

}
