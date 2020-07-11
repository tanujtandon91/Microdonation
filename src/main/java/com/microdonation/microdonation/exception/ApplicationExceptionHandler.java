package com.microdonation.microdonation.exception;


import com.microdonation.microdonation.payload.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.ServiceUnavailableException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LogManager.getLogger(ApplicationExceptionHandler.class);
    private static final String LOG_RESPONSE = "Application exception: {}";

    @ExceptionHandler({GeneralException.class, ApiException.class})
    public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
        LOG.error(LOG_RESPONSE, ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DBException.class)
    public final ResponseEntity<Object> handleSQLException(DBException ex, WebRequest request) {
        LOG.error("SQL Exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> handleValidationException(Exception ex, WebRequest request) {
        LOG.error("Validation Exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public final ResponseEntity<Object> handleServiceUnavailableException(Exception ex, WebRequest request) {
        LOG.error("Service unavailable Exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(HeaderException.class)
    public final ResponseEntity<ExceptionModel> headerException(Exception ex, WebRequest request) {
        LOG.error("Headers exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthorizationException.class)
    public final ResponseEntity<Object> authException(Exception ex, WebRequest request) {
        LOG.error("Authorization Exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<Object> dataNotFound(Exception ex, WebRequest request) {
        LOG.error("Data not found Exception: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> exception(Exception ex, WebRequest request) {
        LOG.error("unhandledException: {}", ex.getMessage());
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, String> errors = new HashMap<String, String>();
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String errorbuffer = "";
        for (FieldError fieldError : fieldErrors) {
            errorbuffer = errorbuffer + fieldError.getDefaultMessage() +",";
        }
        response.put("error", errors);
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(errorbuffer.substring(0,errorbuffer.length()-1))
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponse responseModel =
                new ApiResponse().new ResponseBuilder().setSuccess(false).setMessage(ex.getMessage())
                        .setData(null).build();
        return new ResponseEntity(responseModel, HttpStatus.METHOD_NOT_ALLOWED);
    }
}