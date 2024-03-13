package com.chushi.standard.pojo;

import com.chushi.standard.exception.BusinessException;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 11:07
 * @Description 统一返回结果国际化message组装
 * @ProjectName chushi
 * @PackageName com.chushi.standard.pojo
 * @ClassName ResultI18nMessageAssembler.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ResultI18nMessageAssembler {

    /**
     * 返回国际化message
     *
     * @param businessException 业务异常
     * @return
     */
    String assembler(BusinessException businessException);
}
