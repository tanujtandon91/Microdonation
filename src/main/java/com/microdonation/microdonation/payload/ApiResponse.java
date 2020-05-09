package com.microdonation.microdonation.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T extends Object> implements Serializable {
    private Boolean success;
    private String message;
    private T data;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public ApiResponse(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    public ApiResponse(){

    }
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}