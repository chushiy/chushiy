package com.chushiy.apidatacrypto.anonotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:33
 * @Description 解密生成类
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.anonotation
 * @ClassName DecryptionAnnotation.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {
}

