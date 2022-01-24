package com.cn.leo.login.constants;

import com.cn.leo.common.constants.IResultCode;

public enum ResultCode implements IResultCode {
    CAPTCHA_INVALID(100000,"验证码不正确，请重新输入"),

    ;

    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.desc;
    }
}
