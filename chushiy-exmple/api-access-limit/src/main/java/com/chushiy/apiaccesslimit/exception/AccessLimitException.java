package com.chushiy.apiaccesslimit.exception;

/**
 * @Author 初时y
 * @DateTime 2023/12/2 上午 12:51
 * @Description 访问限制异常
 * @ProjectName chushiy
 * @PackageName com.chushiy.apiaccesslimit.exception
 * @ClassName AccessLimitException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class AccessLimitException extends RuntimeException {
    public AccessLimitException(String s) {
        super(s);
    }
}
