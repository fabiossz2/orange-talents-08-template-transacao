package br.com.zupacademy.fabio.transacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({Exception.class, NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public StandardError handleException(Exception exception) {
        return new StandardError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<StandardError> handleResponseStatusException(ResponseStatusException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(new StandardError(LocalDateTime.now(), exception.getStatus().value(),
                        exception.getStatus().toString(), exception.getReason()));
    }
}
