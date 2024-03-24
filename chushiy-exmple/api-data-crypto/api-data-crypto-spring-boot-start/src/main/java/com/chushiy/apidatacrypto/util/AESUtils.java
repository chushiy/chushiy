package com.chushiy.apidatacrypto.util;

import cn.hutool.crypto.symmetric.AES;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:40
 * @Description aes工具类
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.util
 * @ClassName AESUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Component
public class AESUtils {

    private static AES aes;

    @Resource
    private AES iocAes;

    public static AES getAes() {
        return aes;
    }

    public static String encryptHex(byte[] data) {
        return aes.encryptHex(data);
    }

    public static String encryptHex(InputStream data) {
        return aes.encryptHex(data);
    }

    public static String encryptHex(String data) {
        return aes.encryptHex(data, StandardCharsets.UTF_8);
    }

    /**
     * 解密
     */

    public static String decrypt(byte[] data) {
        return aes.decryptStr(data, StandardCharsets.UTF_8);
    }

    public static String decrypt(InputStream data) {
        return aes.decryptStr(data);
    }

    public static String decrypt(String data) {
        return aes.decryptStr(data, StandardCharsets.UTF_8);
    }

    @PostConstruct
    public void setAes() {
        AESUtils.aes = this.iocAes;
    }

}

