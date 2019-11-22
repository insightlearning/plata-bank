package com.insight.learning.platabank.payeeservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PayeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PayeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String payeeNotFoundHandler(PayeeNotFoundException ex) {
        return ex.getMessage();
    }
}
