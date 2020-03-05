package com.geekymv.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {
        msg = ResultCode.SUCCESS.getMessage();
        code = ResultCode.SUCCESS.getCode();
    }

    public CommonResult(ResultCode rc) {
        msg = rc.getMessage();
        code = rc.getCode();
    }

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.getCode();
    }
}
