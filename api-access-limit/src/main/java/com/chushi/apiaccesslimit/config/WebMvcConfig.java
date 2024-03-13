package com.chushi.apiaccesslimit.config;

import com.chushi.apiaccesslimit.interceptor.AccessLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 初时
 * @DateTime 2023/12/2 上午 12:12
 * @Description webmvc配置
 * @ProjectName chushi
 * @PackageName com.chushi.apiaccesslimit.config
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
