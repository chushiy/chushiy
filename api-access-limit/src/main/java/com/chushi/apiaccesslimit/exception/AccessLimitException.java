package com.chushi.apiaccesslimit.exception;

/**
 * @Author 初时
 * @DateTime 2023/12/2 上午 12:51
 * @Description 访问限制异常
 * @ProjectName chushi
 * @PackageName com.chushi.apiaccesslimit.exception
 * @ClassName AccessLimitException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class AccessLimitException extends RuntimeException {
    public AccessLimitException(String s) {
        super(s);
    }
}
