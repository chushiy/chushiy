package com.chushiy.apidatacrypto.config;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:34
 * @Description AES需要的配置参数
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.config
 * @ClassName CryptConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "crypto")
@PropertySource("classpath:crypto.properties")
@Data
@EqualsAndHashCode
@Getter
public class CryptConfig implements Serializable {

    private Mode mode;
    private Padding padding;
    private String key;
    private String iv;

}

