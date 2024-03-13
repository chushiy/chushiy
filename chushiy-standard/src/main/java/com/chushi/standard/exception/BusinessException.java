package com.chushi.standard.exception;

import com.chushi.standard.exception.support.ErrorSupport;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/6 下午 10:37
 * @Description 业务异常
 * @ProjectName chushi
 * @PackageName com.chushi.standard.exception
 * @ClassName BusinessException.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
public class BusinessException extends RuntimeException implements Serializable {

    private String code;

    public BusinessException(ErrorSupport errorSupport) {
        super(errorSupport.getMessage());
        this.code = errorSupport.getCode();
    }
}
