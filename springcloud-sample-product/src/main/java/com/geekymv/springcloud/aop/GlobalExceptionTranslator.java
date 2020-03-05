package com.geekymv.springcloud.aop;

import com.geekymv.common.api.CommonResult;
import com.geekymv.common.api.ResultCode;
import com.geekymv.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionTranslator {

//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public BaseResponse handleError(MissingServletRequestParameterException e) {
//        log.warn("Missing Request Parameter", e);
//        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
//        return BaseResponse
//                .builder()
//                .code(ResultCode.PARAM_MISS)
//                .message(message)
//                .build();
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public BaseResponse handleError(MethodArgumentTypeMismatchException e) {
//        log.warn("Method Argument Type Mismatch", e);
//        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
//        return BaseResponse
//                .builder()
//                .code(ResultCode.PARAM_TYPE_ERROR)
//                .message(message)
//                .build();
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public BaseResponse handleError(MethodArgumentNotValidException e) {
//        log.warn("Method Argument Not Valid", e);
//        BindingResult result = e.getBindingResult();
//        FieldError error = result.getFieldError();
//        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
//        return BaseResponse
//                .builder()
//                .code(ResultCode.PARAM_VALID_ERROR)
//                .message(message)
//                .build();
//    }

//    @ExceptionHandler(BindException.class)
//    public BaseResponse handleError(BindException e) {
//        log.warn("Bind Exception", e);
//        FieldError error = e.getFieldError();
//        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
//        return BaseResponse
//                .builder()
//                .code(ResultCode.PARAM_BIND_ERROR)
//                .message(message)
//                .build();
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public BaseResponse handleError(ConstraintViolationException e) {
//        log.warn("Constraint Violation", e);
//        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//        ConstraintViolation<?> violation = violations.iterator().next();
//        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
//        String message = String.format("%s:%s", path, violation.getMessage());
//        return BaseResponse
//                .builder()
//                .code(ResultCode.PARAM_VALID_ERROR)
//                .message(message)
//                .build();
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult handleError(NoHandlerFoundException e) {
        log.error("404 Not Found", e);
        return CommonResult
                .builder()
                .code(ResultCode.NOT_FOUND.getCode())
                .msg(e.getMessage())
                .build();
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public BaseResponse handleError(HttpMessageNotReadableException e) {
//        log.error("Message Not Readable", e);
//        return BaseResponse
//                .builder()
//                .code(ResultCode.MSG_NOT_READABLE)
//                .message(e.getMessage())
//                .build();
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public BaseResponse handleError(HttpRequestMethodNotSupportedException e) {
//        log.error("Request Method Not Supported", e);
//        return BaseResponse
//                .builder()
//                .code(ResultCode.METHOD_NOT_SUPPORTED)
//                .message(e.getMessage())
//                .build();
//    }

//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public BaseResponse handleError(HttpMediaTypeNotSupportedException e) {
//        log.error("Media Type Not Supported", e);
//        return BaseResponse
//                .builder()
//                .code(ResultCode.MEDIA_TYPE_NOT_SUPPORTED)
//                .message(e.getMessage())
//                .build();
//    }

    @ExceptionHandler(ServiceException.class)
    public CommonResult handleError(ServiceException e) {
        log.error("Service Exception", e);
        return CommonResult
                .builder()
                .code(e.getResultCode().getCode())
                .msg(e.getMessage())
                .build();
    }

//    @ExceptionHandler(PermissionDeniedException.class)
//    public BaseResponse handleError(PermissionDeniedException e) {
//        log.error("Permission Denied", e);
//        return BaseResponse
//                .builder()
//                .code(e.getResultCode())
//                .message(e.getMessage())
//                .build();
//    }

    @ExceptionHandler(Throwable.class)
    public CommonResult handleError(Throwable e) {
        log.error("Internal Server Error", e);
        return CommonResult
                .builder()
                .code(ResultCode.INTERNAL_SERVER_ERROR.getCode())
                .msg(e.getMessage())
                .build();
    }


}
