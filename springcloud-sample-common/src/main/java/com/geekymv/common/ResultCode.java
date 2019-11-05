package com.geekymv.common;

public enum ResultCode {

    SUCCESS(200, "请求成功"),

    FAILURE(500, "业务异常"),

    NOT_FOUND(404, "404 Not Found"),

    ;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    private final String message;

}
