package com.chang.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ANdady on 2019/2/22.
 */
@ControllerAdvice
public class ErrorHandle {

    private final Logger logger = LoggerFactory.getLogger(ErrorHandle.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error404(Exception  e) {
        logger.error(e.getMessage(), e);
        return "/common/404";
    }
}
