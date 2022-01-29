package com.cn.leo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: RequestParamInterceptor
 * @author: rtliu
 * @date: 2022/1/21 3:29 下午
 */
@Component
public class RequestParamInterceptor implements HandlerInterceptor {
    public static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        USER_ID.set("1111");
        return true;
    }
}
