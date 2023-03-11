package com.practicaltest.controller;

import com.practicaltest.exception.ZipcodeNullException;
import com.practicaltest.exception.ZipcodeValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ShippingPriceControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> error() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Ocorreu um erro genérico");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ZipcodeNullException.class)
    public ResponseEntity<Object> captureNullErrorClient() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "O CEP informado, não foi encontrado.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ZipcodeValidateException.class)
    public ResponseEntity<Object> captureErrorConnectionDB() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "O CEP informado é inválido.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}