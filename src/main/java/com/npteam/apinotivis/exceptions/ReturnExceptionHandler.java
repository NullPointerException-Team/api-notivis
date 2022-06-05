package com.npteam.apinotivis.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ReturnExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ExceptionInterna.class)
  public ResponseEntity<Object> handleNegocio(ExceptionInterna ex, WebRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    Error error = new Error(status.value(), OffsetDateTime.now(), ex.getMessage());

    return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(EntidadeNaoEncontradaException.class)
  public ResponseEntity<Object> handleEntidadeNaoEncontrada(ExceptionInterna ex, WebRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    Error error = new Error(status.value(), OffsetDateTime.now(), ex.getMessage());

    return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
  }
}
