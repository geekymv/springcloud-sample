package com.geekymv.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {
        msg = ResultCode.SUCCESS.getMsg();
        code = ResultCode.SUCCESS.getCode();
    }

    public Result(ResultCode rc) {
        msg = rc.getMsg();
        code = rc.getCode();
    }

    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.getCode();
    }
}
