package com.cn.leo.common.advice;

import com.cn.leo.common.constants.IResultCode;

/**
 * @description: ResBody
 * @author: rtliu
 * @date: 2022/1/21 6:02 下午
 */
public record ResBody<T>(Status status, T data, Integer code, String message) {

    public enum Status {
        OK(200),
        ERROR(500),
        ;

        private Integer code;

        Status(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    public static <T> ResBody<T> success(T... o) {
        return new ResBody<>(
                Status.OK,
                o.length == 0 ? null : o[0],
                Status.OK.getCode(),
                null
        );
    }

    public static <T> ResBody<T> error(IResultCode resultCode, T... o) {
        return new ResBody<>(
                Status.ERROR,
                o.length == 0 ? null : o[0],
                resultCode.getErrorCode(),
                resultCode.getErrorMessage()
        );
    }

    public static <T> ResBody<T> error(String message) {
        return new ResBody<>(Status.ERROR, null, Status.ERROR.getCode(), message);
    }
}
