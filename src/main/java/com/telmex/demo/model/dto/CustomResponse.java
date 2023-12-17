package com.telmex.demo.model.dto;

import org.springframework.http.HttpStatus;

public class CustomResponse {
    private HttpStatus httpStatus;
    private Object data;
    private String message;


    private CustomResponse(CustomResponseBuilder customResponseBuilder) {
        this.data = customResponseBuilder.data;
        this.httpStatus = customResponseBuilder.httpStatus;
        this.message = customResponseBuilder.message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class CustomResponseBuilder {
        private HttpStatus httpStatus;
        private Object data;
        private String message;

        public CustomResponseBuilder(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public CustomResponseBuilder setData(Object data) {
            this.data = data;
            return this;
        }

        public CustomResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public CustomResponse builder(){
            return new CustomResponse(this);
        }
    }
}
