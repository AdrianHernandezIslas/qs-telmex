package com.telmex.demo.exceptions;

import com.telmex.demo.dto.CustomResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<CustomResponse> handleException(HttpServletResponse response,Exception exception){
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.CONFLICT).builder();
        customResponse.setMessage(exception.getCause().getCause().getMessage());
        response.setStatus(customResponse.getHttpStatus().value());
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomResponse> handleExceptionFatal(HttpServletResponse response,Exception exception){
        CustomResponse customResponse = new  CustomResponse.CustomResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).builder();
        customResponse.setMessage(exception.getCause().getMessage());
        response.setStatus(customResponse.getHttpStatus().value());
        return ResponseEntity.status(customResponse.getHttpStatus()).body(customResponse);
    }
}
