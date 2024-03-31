package com.chushiy.apidatacrypto.config;

import cn.hutool.crypto.symmetric.AES;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:36
 * @Description api数据加解密配置类
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.config
 * @ClassName PpiDataCryptoApplicationConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Configuration
public class ApiDataCryptoApplicationConfig {

    @Resource
    private CryptConfig cryptConfig;

    @Bean
    public AES aes() {
        return new AES(cryptConfig.getMode(), cryptConfig.getPadding(), cryptConfig.getKey().getBytes(StandardCharsets.UTF_8), cryptConfig.getIv().getBytes(StandardCharsets.UTF_8));
    }

}

