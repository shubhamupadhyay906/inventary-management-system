package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ApiError {

    private int number;

    private String message;

    private Date date;

}
