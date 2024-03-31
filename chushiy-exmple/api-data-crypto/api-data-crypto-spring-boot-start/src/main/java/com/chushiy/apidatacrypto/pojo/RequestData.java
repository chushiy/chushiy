package com.chushiy.apidatacrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:39
 * @Description TODO
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.pojo
 * @ClassName RequestData.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class RequestData implements Serializable {

    // 加密的文本
    private String text;

}

