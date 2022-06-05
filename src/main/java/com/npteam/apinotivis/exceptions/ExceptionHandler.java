package com.npteam.apinotivis.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatus status,
                                                                WebRequest request) {
    List<Error.Campo> campos = new ArrayList<>();

    for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
      String nomeError = ((FieldError) erro).getField();
      String mensagem = erro.getDefaultMessage();

      campos.add(new Error.Campo(nomeError, mensagem));
    }
    Error error = new Error(status.value(), OffsetDateTime.now(), "Um ou mais campos estão inválidos.", campos);
    return handleExceptionInternal(ex, error, headers, status, request);
  }
}
