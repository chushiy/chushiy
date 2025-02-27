package com.chushiy.apilimitcount.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @DateTime 2023/12/2 上午 1:02
 * @Description 接口限制次数
 * @ProjectName chushiy
 * @PackageName com.chushiy.api.limit.count
 * @ClassName LimitCount.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitCount {

    /**
     * 资源名称，用于描述接口功能
     */
    String name() default "";

    /**
     * 资源 key
     */
    String key() default "";

    /**
     * key prefix
     *
     * @return
     */
    String prefix() default "";

    /**
     * 时间的，单位秒
     * 默认60s过期
     */
    int period() default 60;

    /**
     * 限制访问次数
     * 默认3次
     */
    int count() default 3;
}
