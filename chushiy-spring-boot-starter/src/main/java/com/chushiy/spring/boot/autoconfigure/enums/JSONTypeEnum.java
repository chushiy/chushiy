package com.chushiy.spring.boot.autoconfigure.enums;

import lombok.AllArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 3:10
 * @Description json类型
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.enums
 * @ClassName JSONTypeEnum.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@AllArgsConstructor
public enum JSONTypeEnum {

    FASTJSON("fastjson","fastjson"),
    GSON("gson","gson"),
    JACKSON("jackson","jackson")
    ;

    private String name;
    private String desc;
}
