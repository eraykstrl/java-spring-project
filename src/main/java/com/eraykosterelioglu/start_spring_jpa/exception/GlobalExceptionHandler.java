package com.eraykosterelioglu.start_spring_jpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorsMap = new HashMap<>();

        for(ObjectError objError : ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objError).getField();
            if(errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName,addMapValue(errorsMap.get(fieldName),objError.getDefaultMessage()));
            }
            else {
                errorsMap.put(fieldName,addMapValue(new ArrayList<>(),objError.getDefaultMessage()));
            }
        }
        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private List<String> addMapValue(List<String> errors, String error) {
        errors.add(error);
        return errors;
    }

    private <T> ApiError <T> createApiError(T errors) {

        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
