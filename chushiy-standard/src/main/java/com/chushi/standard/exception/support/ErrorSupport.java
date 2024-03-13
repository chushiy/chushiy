package com.chushi.standard.exception.support;

import com.chushi.standard.support.ModuleSupport;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 7:01
 * @Description 错误支持 策略模式 提供扩展 错误码为8位
 * @ProjectName chushi
 * @PackageName com.chushi.standard.exception.support
 * @ClassName ErrorSupport.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ErrorSupport {

    /**
     * 是否是系统错误
     * @return
     */
    boolean isSystemError();

    /**
     * 模块
     * @return
     */
    ModuleSupport getModule();

    String getCode();

    String getMessage();
}
