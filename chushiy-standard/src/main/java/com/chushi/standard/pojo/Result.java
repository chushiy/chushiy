package com.chushi.standard.pojo;

import com.chushi.standard.constant.ResponseConstant;
import com.chushi.standard.exception.BusinessException;
import com.chushi.standard.exception.support.ErrorSupport;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 5:09
 * @Description 统一返回结果 支持国际化使用JAVA SPI机制 提供扩展性
 * @ProjectName chushi
 * @PackageName com.chushi.standard.pojo
 * @ClassName Result.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class Result<T> implements VO {

    /**
     * 代码 使用字符串类型
     * 使用int类型有弊端 0001
     */
    private final String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    private Result() {
        this.code = ResponseConstant.SUCCESS_CODE;
    }

    private Result(String message) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.message = message;
    }

    private Result(T data) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.data = data;
    }


    private Result(String message, T data) {
        this.code = ResponseConstant.SUCCESS_CODE;
        this.message = message;
        this.data = data;
    }

    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result<Void> success() {
        return new Result<>("操作成功");
    }

    public static Result<Void> success(String message) {
        return new Result<>(message, null);
    }

    public static <T> Result<T> success(T data) {
        // 操作成功考虑国际化的问题
        return new Result<>("操作成功", data);
    }

    public static Result<Void> fail() {
        // TODO 支持国际化
        return new Result<>(ResponseConstant.FAIL_CODE, "操作失败");
    }

    public static Result<Void> fail(ErrorSupport errorSupport) {
        return new Result<>(errorSupport.getCode(), errorSupport.getMessage());
    }

    public static Result<Void> fail(BusinessException businessException) {
        return new Result<>(businessException.getCode(), businessException.getMessage());
    }
}
