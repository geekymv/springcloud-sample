package com.geekymv.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class BaseResponse {

    private String message;

    private int code;

    public BaseResponse() {
        message = ResultCode.SUCCESS.getMessage();
        code = ResultCode.SUCCESS.getCode();
    }

    public BaseResponse(ResultCode rc) {
        message = rc.getMessage();
        code = rc.getCode();
    }

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.getCode();
    }

}
