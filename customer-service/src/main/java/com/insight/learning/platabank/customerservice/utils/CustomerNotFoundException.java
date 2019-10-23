package com.insight.learning.platabank.customerservice.utils;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }

}
