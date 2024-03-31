package com.chushiy.apidatacrypto.advice;

import com.chushiy.apidatacrypto.exception.CryptoException;
import com.chushiy.apidatacrypto.exception.CustomizeException;
import com.chushiy.apidatacrypto.exception.ParamException;
import com.chushiy.apidatacrypto.pojo.Result;
import com.chushiy.apidatacrypto.pojo.ResultBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:21
 * @Description 统一异常处理类
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.advice
 * @ClassName GlobExceptionHandlerAdvice.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RestControllerAdvice  // 返回json
public class GlobExceptionHandlerAdvice implements ResultBuilder {

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Result<?>> bindExceptionHandler(BindException ex) {
        ex.printStackTrace();
        // 获取所有错误信息，拼接
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String errorMsg = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage())
                .collect(Collectors.joining(","));
        // 返回统一处理类
        return badRequest(errorMsg);
    }

    @ExceptionHandler(value = ParamException.class)
    public ResponseEntity<Result<?>> paramExceptionHandler(ParamException ex) {
        ex.printStackTrace();
        // 返回统一处理类
        return badRequest(ex.getMessage());
    }

    @ExceptionHandler(value = CryptoException.class)
    public ResponseEntity<Result<?>> cryptoExceptionHandler(CryptoException ex) {
        ex.printStackTrace();
        // 返回统一处理类
        return internalServerError(ex.getMessage());
    }

    @ExceptionHandler(value = CustomizeException.class)
    public ResponseEntity<Result<?>> customizeExceptionHanlder(CustomizeException ex) {
        ex.printStackTrace();
        // 返回统一处理类
        return internalServerError(ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result<?>> exceptionHanlder(Exception ex) {
        ex.printStackTrace();
        // 返回统一处理类
        return internalServerError(ex.getMessage());
    }

}

