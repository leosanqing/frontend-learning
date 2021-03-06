package com.cn.leo.exception;


import com.cn.leo.constants.IResultCode;
import lombok.Getter;

@Getter
public class BaseRuntimeException extends RuntimeException {

    private IResultCode resultCode;

    public BaseRuntimeException(IResultCode resultCode) {
        super(resultCode.getErrorMessage());
        this.resultCode = resultCode;
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(Throwable cause, IResultCode resultCode) {
        super(cause);
        this.resultCode = resultCode;
    }
}
