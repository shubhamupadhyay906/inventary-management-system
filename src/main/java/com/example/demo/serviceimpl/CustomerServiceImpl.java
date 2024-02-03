package com.example.demo.serviceimpl;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addNewCustomer(Customer customer) {
        log.info("In customer Service class");
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        log.info("In customer Service class");
        return customerRepository.findAll();
    }

}
