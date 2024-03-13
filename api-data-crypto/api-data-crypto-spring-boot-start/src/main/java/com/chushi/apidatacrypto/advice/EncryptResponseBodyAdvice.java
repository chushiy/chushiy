package com.chushi.apidatacrypto.advice;

import cn.hutool.json.JSONUtil;
import com.chushi.apidatacrypto.anonotation.Encrypt;
import com.chushi.apidatacrypto.exception.CryptoException;
import com.chushi.apidatacrypto.pojo.RequestBase;
import com.chushi.apidatacrypto.pojo.Result;
import com.chushi.apidatacrypto.util.AESUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:31
 * @Description responseBody自动解密
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.advice
 * @ClassName EncryptResponseBodyAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Result<?>> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ParameterizedTypeImpl genericParameterType = (ParameterizedTypeImpl) returnType.getGenericParameterType();

        // 如果直接是Result并且有解密注解，则处理
        if (genericParameterType.getRawType() == Result.class && returnType.hasMethodAnnotation(Encrypt.class)) {
            return true;
        }

        // 如果不是ResponseBody或者是Result，则放行
        if (genericParameterType.getRawType() != ResponseEntity.class) {
            return false;
        }

        // 如果是ResponseEntity<Result>并且有解密注解，则处理
        for (Type type : genericParameterType.getActualTypeArguments()) {
            if (((ParameterizedTypeImpl) type).getRawType() == Result.class && returnType.hasMethodAnnotation(Encrypt.class)) {
                return true;
            }
        }

        return false;
    }

    @SneakyThrows
    @Override
    public Result<?> beforeBodyWrite(Result<?> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        // 真实数据
        Object data = body.getData();

        // 如果data为空，直接返回
        if (data == null) {
            return body;
        }

        // 如果是实体，并且继承了Request，则放入时间戳
        if (data instanceof RequestBase) {
            ((RequestBase) data).setCurrentTimeMillis(System.currentTimeMillis());
        }

        String dataText = JSONUtil.toJsonStr(data);

        // 如果data为空，直接返回
        if (StringUtils.isBlank(dataText)) {
            return body;
        }

        // 如果位数小于16，报错
        if (dataText.length() < 16) {
            throw new CryptoException("加密失败，数据小于16位");
        }

        String encryptText = AESUtils.encryptHex(dataText);

        return Result.builder()
                .status(body.getStatus())
                .data(encryptText)
                .message(body.getMessage())
                .build();
    }
}

