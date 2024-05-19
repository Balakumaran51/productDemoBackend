package com.cartManagement.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Invalid extends RuntimeException{
    public Invalid(String message){
        super(message);
    }
}
