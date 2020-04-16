package com.geekymv.common.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this(ResultCode.SUCCESS,  data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> fail(ResultCode resultCode, T data) {
        return new Result(resultCode, data);
    }

    public static <T> Result<T> fail(ResultCode resultCode) {
        return new Result(resultCode, null);
    }

    public boolean success() {
        return code == ResultCode.SUCCESS.getCode();
    }
}
