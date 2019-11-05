package com.geekymv.common.exception;

import com.geekymv.common.api.ResultCode;
import lombok.Getter;

public class ServiceException extends RuntimeException {

    @Getter
    private final ResultCode resultCode;

    public ServiceException() {
        this.resultCode = ResultCode.FAILURE;
    }

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public ServiceException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }
}
