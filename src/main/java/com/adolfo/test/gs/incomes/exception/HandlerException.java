package com.adolfo.test.gs.incomes.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFoudException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "El recurso no fue encontrado en base de datos");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());

        return error;
    }

    @ExceptionHandler(value = {Exception.class, IllegalArgumentException.class, ClassNotFoundException.class, IllegalStateException.class, RuntimeException.class,
        NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> globalException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Error en el servidor");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, Object> forbiddenException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "No se puede procesar la solicitud");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.FORBIDDEN.value());

        return error;
    }
}
