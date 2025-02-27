package com.chushiy.apidatacrypto.exception;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:19
 * @Description 自定义异常
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.exception
 * @ClassName CryptoException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class CryptoException extends CustomizeException {

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoException(String message) {
        super(message);
    }

}

