package com.chushiy.apidatacrypto.exception;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:20
 * @Description 自定义异常
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.exception
 * @ClassName CustomizeException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class CustomizeException extends Exception {

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeException(String message) {
        super(message);
    }

}

