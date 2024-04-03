package com.telmex.demo.exceptions;

import com.telmex.demo.dto.CustomResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<CustomResponse> handleException(HttpServletResponse response,Exception exception){
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.CONFLICT).builder();
        customResponse.setMessage(exception.getCause().getCause().getMessage());
        response.setStatus(customResponse.getHttpStatus().value());
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.BAD_REQUEST).builder();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        customResponse.setMessage("Los parametros enviados son incorrectos");
        customResponse.setData(errors);
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomResponse> handleExceptionFatal(HttpServletResponse response,Exception exception){
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).builder();
        customResponse.setMessage(exception.getCause().getMessage());
        response.setStatus(customResponse.getHttpStatus().value());
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<CustomResponse> handleAuthenticationException(HttpServletResponse response,Exception exception){
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.UNAUTHORIZED).builder();
        AuthenticationException authenticationException = (AuthenticationException) exception;
        customResponse.setMessage(authenticationException.getMessage());
        response.setStatus(customResponse.getHttpStatus().value());
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.BAD_REQUEST).builder();
        return  ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
