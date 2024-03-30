package com.chushiy.oss.test;

import com.chushiy.oss.spring.boot.autoconfigure.core.OSSTemplate;
import com.chushiy.pss.test.OSSTestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/30 下午 5:26
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy.oss.test
 * @ClassName OSSTemplateTest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@SpringBootTest(classes = {OSSTestApplication.class})
public class OSSTemplateTest {

    @Autowired
    private OSSTemplate ossTemplate;

    @Test
    void testCreateBucket() {
        this.ossTemplate.createBucket("test-bucket2");
    }

}
