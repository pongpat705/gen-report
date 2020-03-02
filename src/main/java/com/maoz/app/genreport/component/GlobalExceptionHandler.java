package com.maoz.app.genreport.component;

import com.maoz.app.genreport.modules.core.MessageEnum;
import com.maoz.app.genreport.modules.core.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> noHandlerFoundException(
            NoHandlerFoundException ex) {

        return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> missingServletRequestParameterException(
            MissingServletRequestParameterException ex) {

        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> missingServletRequestParameterException(
            BadSqlGrammarException ex) {

        return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}
