package com.myfactory.restfulspringbootmongodb.resources.exceptions;

import com.myfactory.restfulspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // isso avisa pro framework que quando der essa exceção, é pra tratar da maneira como está estabelecido abaixo
    public ResponseEntity<StandardError> objectNotFound (
            ObjectNotFoundException e,
            HttpServletRequest httpServletRequest
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado. ",
                e.getMessage(),
                httpServletRequest.getRequestURI()
                );
        return ResponseEntity.status(status).body(standardError);
    }

}
