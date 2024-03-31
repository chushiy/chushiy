package com.chushiy.apiaccesslimit.config;

import com.chushiy.apiaccesslimit.interceptor.AccessLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 初时y
 * @DateTime 2023/12/2 上午 12:12
 * @Description webmvc配置
 * @ProjectName chushiy
 * @PackageName com.chushiy.apiaccesslimit.config
 * @ClassName WebMvcConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLimitInterceptor());
    }
}
