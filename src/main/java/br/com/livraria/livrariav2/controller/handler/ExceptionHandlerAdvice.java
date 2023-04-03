package br.com.livraria.livrariav2.controller.handler;

import br.com.livraria.livrariav2.exception.ExceptionMessage;
import br.com.livraria.livrariav2.exception.FieldErrorMessage;
import br.com.livraria.livrariav2.exception.FieldMessage;
import br.com.livraria.livrariav2.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> exceptionNotFound(NotFoundException exception, WebRequest request) {
        ExceptionMessage message = new ExceptionMessage();

        message.setMessage(exception.getMessage());
        message.setStatus(HttpStatus.NOT_FOUND.value());
        message.setError(HttpStatus.NOT_FOUND.name());
        message.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        FieldErrorMessage message = new FieldErrorMessage();

        message.setError(HttpStatus.BAD_REQUEST.name());
        message.setStatus(HttpStatus.BAD_REQUEST.value());
        message.setTimestamp(System.currentTimeMillis());

        List<FieldMessage> errors = new ArrayList<FieldMessage>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String fieldMessage = error.getDefaultMessage();
            errors.add(new FieldMessage(fieldName, fieldMessage));
        });

        message.setMessages(errors);
        return new ResponseEntity<FieldErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
}