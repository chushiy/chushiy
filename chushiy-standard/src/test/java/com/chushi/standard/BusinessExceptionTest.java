package com.chushi.standard;

import com.chushi.standard.exception.BusinessException;
import com.chushi.standard.exception.support.DefaultError;
import org.junit.jupiter.api.Test;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/16 下午 5:08
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushi.standard
 * @ClassName BusinessExceptionTest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class BusinessExceptionTest {

    @Test
    void test() {
        BusinessException exception = new BusinessException("测试异常={}", new RuntimeException(), "参数");
        System.out.println(exception);
    }

    @Test
    void test2() {
        System.out.println(new BusinessException(DefaultError.UN_AUTHORIZED));
    }
}
