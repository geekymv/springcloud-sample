package com.geekymv.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {

    SUCCESS(200, "请求成功"),

    FAILURE(400, "业务异常"),

    NOT_FOUND(404, "404 Not Found"),


    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    ;


    private final int code;

    private final String message;

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
