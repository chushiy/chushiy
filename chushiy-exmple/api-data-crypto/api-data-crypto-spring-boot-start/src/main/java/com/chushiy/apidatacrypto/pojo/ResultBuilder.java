package com.chushiy.apidatacrypto.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author 初时y
 * @DateTime 2023/12/1 下午 7:16
 * @Description 统一的返回结果构造器
 * @ProjectName api-data-crypto
 * @PackageName com.chushiy.apidatacrypto.common.pojo
 * @ClassName ResultBuilder.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ResultBuilder {

    /**
     * 成功的构造
     *
     * @param data 数据
     * @return Result
     */
    default ResponseEntity<Result<?>> success(Object data) {
        return ResponseEntity.ok(Result.builder()
                .status(HttpStatus.OK.value()).data(data)
                .build());
    }

    /**
     * 400的构造
     *
     * @param errorMsg 错误信息
     * @return Result
     */
    default ResponseEntity<Result<?>> badRequest(String errorMsg) {
        return ResponseEntity.badRequest().body(Result.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errorMsg)
                .build());
    }

    /**
     * 404的构造
     *
     * @param errorMsg 错误信息
     * @return Result
     */
    default ResponseEntity<Result<?>> notFound(String errorMsg) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(Result.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(errorMsg)
                        .build());
    }

    /**
     * 500的构造
     *
     * @param errorMsg 错误信息
     * @return Result
     */
    default ResponseEntity<Result<?>> internalServerError(String errorMsg) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(Result.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(errorMsg)
                        .build());
    }

}

