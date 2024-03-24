package com.chushiy.spring.boot.autoconfigure.properties;

import com.chushiy.spring.boot.autoconfigure.enums.JSONTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 2:51
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.properties
 * @ClassName ChuShiYProperties.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "chushiy")
public class ChuShiYProperties {

    /**
     * name
     */
    private String name;

    /**
     * json类型
     */
    private JSONTypeEnum jsonType;
}
