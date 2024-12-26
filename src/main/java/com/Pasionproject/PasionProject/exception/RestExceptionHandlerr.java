package com.Pasionproject.PasionProject.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandlerr extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException rnfe){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimeStamp(new Date().toString());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setTitle("Resource Not Found");
        errorDetails.setDetails(rnfe.getMessage());
        errorDetails.setDeveloperMessage(rnfe.getClass().getName());

        ValidationError validationError = new ValidationError();
        validationError.setMessage(rnfe.getMessage());
        validationError.setCode(rnfe.toString());
        List<ValidationError> errors = new ArrayList<>();

        errors.add(validationError);

        errorDetails.getErrors().put("Not Found", errors);

        return new ResponseEntity<>(errorDetails, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TooManyResoursesAddedException.class)
    public ResponseEntity<?> handleTooManyResources(TooManyResoursesAddedException tmrae){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimeStamp(new Date().toString());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setTitle("Too many resources added");
        errorDetails.setDetails(tmrae.getMessage());
        errorDetails.setDeveloperMessage(tmrae.getClass().getName());

        ValidationError validationError = new ValidationError();
        validationError.setMessage(tmrae.getMessage());
        validationError.setCode(tmrae.toString());
        List<ValidationError> errors = new ArrayList<>();

        errors.add(validationError);

        errorDetails.getErrors().put("Too Many, Lower the amount", errors);

        return new ResponseEntity<>(errorDetails, null, HttpStatus.NOT_FOUND);
    }




    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimeStamp(new Date().toString());
        errorDetails.setStatus(status.value());
        errorDetails.setTitle("Message Not Readable");
        errorDetails.setDetails(ex.getMessage());
        errorDetails.setDeveloperMessage(ex.getClass().getName());

        ValidationError validationError = new ValidationError();

        validationError.setCode(ex.toString());
        validationError.setMessage(ex.getLocalizedMessage());

        List<ValidationError> errors = new ArrayList<>();

        errors.add(validationError);

        errorDetails.getErrors().put("Not Readable", errors);


        return handleExceptionInternal(ex, errorDetails, headers, status, request);
    }

}
