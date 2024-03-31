package com.chushiy.apidatacrypto.filter;

import com.chushiy.apidatacrypto.util.InputStreamHttpServletRequestWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:24
 * @Description 请求流转换为多次读取的请求流 过滤器
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.filter
 * @ClassName HttpServletRequestInputStreamFilter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)  // 优先级最高
public class HttpServletRequestInputStreamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 转换为可以多次获取流的request
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        InputStreamHttpServletRequestWrapper inputStreamHttpServletRequestWrapper = new InputStreamHttpServletRequestWrapper(httpServletRequest);

        // 放行
        chain.doFilter(inputStreamHttpServletRequestWrapper, response);
    }
}

