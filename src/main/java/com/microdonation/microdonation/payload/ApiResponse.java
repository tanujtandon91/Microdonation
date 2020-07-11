package com.microdonation.microdonation.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private ApiResponse(ResponseBuilder builder) {
        this.success = builder.success;
        this.message = builder.message;
        this.data = (T)builder.data;
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

    public static class ResponseBuilder<T extends Object> {
        @JsonProperty(value = "success")
        private boolean success;
        @JsonProperty(value = "message")
        private String message;
        @JsonProperty(value = "data")
        private T data;

        public ResponseBuilder setSuccess(boolean success) {
            this.success = success;
            return this;
        }


        public ResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder setData(T data ) {
            this.data = data;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }
}