package com.chushiy.spring.boot.autoconfigure.advice;

import com.chushiy.standard.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 6:33
 * @Description restful控制器响应包装
 * @ProjectName chushiy
 * @PackageName com.chushi.standard.advice
 * @ClassName RestControllerResponseAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class RestControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean isResult = returnType.getParameterType().isAssignableFrom(Result.class);
        boolean isModelAndView = returnType.getParameterType().equals(ModelAndView.class);
        return !isResult && !isModelAndView;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException ex) {
                return Result.fail();
            }
        } else {
            return Result.success(body);
        }
    }
}
