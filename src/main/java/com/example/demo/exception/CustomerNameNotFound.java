package com.example.demo.exception;

public class CustomerNameNotFound extends Exception {

    private static final long serialVersionUID = 1L;
    private static String message;

    public String getMessage() {
        return message;
    }

    public CustomerNameNotFound(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
