package com.chushi.standard.controller;

import com.chushi.standard.exception.BusinessException;
import com.chushi.standard.exception.support.ErrorSupport;
import com.chushi.standard.pojo.Result;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/23 下午 7:21
 * @Description controller基类
 * @ProjectName chushi
 * @PackageName com.chushi.standard.controller
 * @ClassName Controller.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@org.springframework.stereotype.Controller
public class Controller {

    public Result<Void> success(String message) {
        return Result.success(message);
    }

    public <T> Result<T> success(T data) {
        return Result.success(data);
    }

    public <T> Result<T> success(String message, T data) {
        return Result.success(data);
    }

    public Result<Void> fail() {
        return Result.fail();
    }

    public Result<Void> fail(ErrorSupport errorSupport) {
        return Result.fail(errorSupport);
    }

    public Result<Void> fail(BusinessException businessException) {
        return Result.fail(businessException);
    }
}
