package com.liliana.DentalCareCenterProject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler({ResourceNotFoundException.class})
    public String processResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return resourceNotFoundException.getMessage();
    }

}
