package com.example.demo.service;

import com.example.demo.exception.StockNameNotFound;
import com.example.demo.model.Stocks;

import java.util.List;

public interface StockService {

    public void addStock(Stocks stock);

    public List<Stocks> sortByProductName();

    public Stocks getSpecificStock(String productName) throws StockNameNotFound;

}
