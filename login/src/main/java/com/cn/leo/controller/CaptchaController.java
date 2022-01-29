package com.cn.leo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.cn.leo.constants.ResultCode;
import com.cn.leo.exception.BaseRuntimeException;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.cn.leo.interceptor.RequestParamInterceptor.USER_ID;

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

    @GetMapping("/user/login/captcha")
    public Captcha getCaptcha() {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(100, 50);
        CAPTCHA_MAP.put(USER_ID.get(), circleCaptcha.getCode());

        return new Captcha(circleCaptcha.getImageBase64Data());
    }


    @PostMapping("/user/login/captcha/verify")
    public void getCaptcha(String code) {
        if (!CAPTCHA_MAP.get(USER_ID.get()).equals(code)) {
            throw new BaseRuntimeException(ResultCode.CAPTCHA_INVALID);
        }
    }

    @Data
    public static class LoginReq {
        private String username;
        private String password;
        private String captcha;
    }

    record UserInfo(String token) {
    }

    @PostMapping("/user/login")

    public UserInfo login(@RequestBody LoginReq req) {
        if (!CAPTCHA_MAP.get(USER_ID.get()).equals(req.captcha)) {
            throw new BaseRuntimeException(ResultCode.CAPTCHA_INVALID);
        }

        return new UserInfo("super_admin");
    }

}
