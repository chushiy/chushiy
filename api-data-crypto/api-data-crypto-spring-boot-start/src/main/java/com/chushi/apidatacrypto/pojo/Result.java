package com.chushi.apidatacrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:15
 * @Description 统一的返回结果
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.common
 * @ClassName Result.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Result<T> {

    @Builder.Default
    private int status = HttpStatus.OK.value();

    private T data;

    @Builder.Default
    private String message = "成功";

}

