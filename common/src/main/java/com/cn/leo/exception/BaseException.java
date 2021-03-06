package com.cn.leo.exception;


import com.cn.leo.constants.IResultCode;

public class BaseException extends Exception {
    private IResultCode resultCode;

    public BaseException() {
        super();
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(IResultCode resultCode) {
        super(resultCode.getErrorMessage());
        this.resultCode = resultCode;
    }
}
