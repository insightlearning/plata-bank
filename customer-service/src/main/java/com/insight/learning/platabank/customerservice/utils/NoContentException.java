package com.insight.learning.platabank.customerservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{

    public NoContentException(String message) {
        super(message);
    }
}
