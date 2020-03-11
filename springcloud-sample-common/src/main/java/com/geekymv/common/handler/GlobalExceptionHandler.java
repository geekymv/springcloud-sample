package com.geekymv.common.handler;

import com.geekymv.common.model.Result;
import com.geekymv.common.model.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    public Result<String> jsonErrorHandler(HttpServletRequest req, Throwable e) throws Exception {
        logger.error("request url : " + req.getRequestURL().toString());
        logger.error("error message : ", e);
        ResultCode businessError = ResultCode.BUSINESS_ERROR;
        if(e instanceof NoHandlerFoundException) {
            businessError = ResultCode.RESOURCES_NOT_FOUND;
        }
        businessError.setMsg(e.getMessage());
        return new Result(businessError);
    }

}
