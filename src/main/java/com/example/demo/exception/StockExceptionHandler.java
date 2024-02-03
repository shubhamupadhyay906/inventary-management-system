package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class StockExceptionHandler {

    @ExceptionHandler(StockNameNotFound.class)
    public ResponseEntity<ApiError> handleStockNameNotFoundException(StockNameNotFound stock) {
        ApiError error = new ApiError(404, stock.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalNotFoundException(Exception ex) {
        ApiError error = new ApiError(404, ex.getMessage(), new Date());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
