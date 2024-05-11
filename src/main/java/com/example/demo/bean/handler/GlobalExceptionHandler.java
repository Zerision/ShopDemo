
package com.example.demo.bean.handler;


import com.example.demo.utils.R;
import com.example.demo.utils.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Global exception handling
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * ServiceException
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public R serviceException(ServiceException e) {
        log.info("ex={}", e.getMessage(), e);
        return new R<>(e);
    }

    /**
     * MethodArgumentNotValidException
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        List<ObjectError> allErrors = exception.getAllErrors();
        StringBuilder stringBuilder=new StringBuilder();
        for (ObjectError error : allErrors) {
            stringBuilder.append(error.getDefaultMessage()).append("\n");
        }
        return R.fail(stringBuilder.toString());
    }
}
