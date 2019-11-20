package com.insight.learning.platabank.payeeservice.utils;

public class PayeeNotFoundException extends RuntimeException{

    public PayeeNotFoundException(Long id) {
        super("Could not find payee " + id);
    }

}
