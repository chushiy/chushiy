package com.chushiy.apiaccesslimit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 11:41
 * @Description 访问限制
 * @ProjectName chushi
 * @PackageName com.chushi.apiaccesslimit.annotation
 * @ClassName AccessLimit.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AccessLimit {

    /**
     * 当前用户id
     *
     * @return
     */
    long currentUserId();

    /**
     * 指定时间内
     * @return
     */
    int seconds();

    /**
     * 最大次数
     *
     * @return
     */
    int maxCount();

    /**
     * 是否需要登录
     *
     * @return
     */
    boolean isLogin() default true;
}
