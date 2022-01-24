package com.cn.leo.login.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.cn.leo.common.exception.BaseRuntimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.cn.leo.common.interceptor.RequestParamInterceptor.USER_ID;
import static com.cn.leo.login.constants.ResultCode.CAPTCHA_INVALID;

/**
 * @description: CaptchaController
 * @author: rtliu
 * @date: 2022/1/21 1:51 下午
 */
@RestController
public class CaptchaController {

    private static final Map<String, String> CAPTCHA_MAP;

    static {
        CAPTCHA_MAP = new ConcurrentHashMap<>();
    }


    record Captcha(String captcha) {
    }

    @GetMapping("login/captcha")
    public Captcha getCaptcha() {

        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200, 100);
        CAPTCHA_MAP.put(USER_ID.get(), circleCaptcha.getCode());

        return new Captcha(circleCaptcha.getImageBase64());
    }


    @PostMapping("login/captcha/verify")
    public void getCaptcha(String code) {
        if (!CAPTCHA_MAP.get(USER_ID.get()).equals(code)) {
            throw new BaseRuntimeException(CAPTCHA_INVALID);
        }
    }

}
