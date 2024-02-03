package com.example.demo.service;

import com.example.demo.exception.StockNameNotFound;
import com.example.demo.model.Orders;

import java.util.List;

public interface OrderService {


    public void addNewOrder(Orders orders) throws StockNameNotFound;

    public List<Orders> getOrders();


}
