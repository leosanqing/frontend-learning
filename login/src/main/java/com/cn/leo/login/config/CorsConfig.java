package com.cn.leo.login.config;

import com.cn.leo.common.interceptor.RequestParamInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //项目中的所有接口都支持跨域
        registry.addMapping("/**")
                //所有地址都可以访问，也可以配置具体地址
                .allowedOrigins("*")
                .allowCredentials(false)
                //"GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestParamInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}