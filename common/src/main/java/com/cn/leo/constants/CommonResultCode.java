package com.cn.leo.constants;

public enum CommonResultCode implements IResultCode {
    SYSTEM_LOGIC_ERROR(9001, "系统错误"),
    RPC_ERROR(9002, "远程服务调用失败"),
    JSON_PARSE_ERROR(9003, "json字符串解析错误"),
    AUTHENTICATION_ERROR(9004, "验证失败 请重新登录"),
    SESSION_INVALID(9005, "已在其他地方重新登录 请确认"),
    LOGIN_FAIL(9006, "用户名或者密码输入错误"),
    TYPE_MISMATCH_EXCEPTION(9007, "请求参数类型异常"),

    VERIFY_SIGN_HEAD_MISS(9101, "sign api head param miss"),
    VERIFY_SIGN_PUBLIC_KEY_MISS(9102, "sign api public key miss"),
    VERIFY_SIGN_FAIL(9103, "sign api check error"),

    ;

    private int code;
    private String desc;

    CommonResultCode(int code, String desc) {
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
