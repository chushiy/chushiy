package com.chushiy.apidatacrypto.controller;

import com.chushiy.apidatacrypto.anonotation.Decrypt;
import com.chushiy.apidatacrypto.anonotation.Encrypt;
import com.chushiy.apidatacrypto.pojo.Result;
import com.chushiy.apidatacrypto.pojo.ResultBuilder;
import com.chushiy.apidatacrypto.pojo.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 8:24
 * @Description TODO
 * @ProjectName chushi
 * @PackageName com.chushi.apidatacrypto.controller
 * @ClassName TestController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RestController
public class TestController implements ResultBuilder {

    /**
     * 直接返回对象，不加密
     *
     * @param teacher Teacher对象
     * @return 不加密的对象
     */
    @PostMapping("/get")
    public ResponseEntity<Result<?>> get(@Validated @RequestBody Teacher teacher) {
        return success(teacher);
    }

    /**
     * 返回加密后的数据
     *
     * @param teacher Teacher对象
     * @return 返回加密后的数据 ResponseBody<Result>格式
     */
    @PostMapping("/encrypt")
    @Encrypt
    public ResponseEntity<Result<?>> encrypt(@Validated @RequestBody Teacher teacher) {
        return success(teacher);
    }

    /**
     * 返回加密后的数据
     *
     * @param teacher Teacher对象
     * @return 返回加密后的数据 Result格式
     */
    @PostMapping("/encrypt1")
    @Encrypt
    public Result<?> encrypt1(@Validated @RequestBody Teacher teacher) {
        return success(teacher).getBody();
    }

    /**
     * 返回解密后的数据
     *
     * @param teacher Teacher对象
     * @return 返回解密后的数据
     */
    @PostMapping("/decrypt")
    @Decrypt
    public ResponseEntity<Result<?>> decrypt(@Validated @RequestBody Teacher teacher) {
        return success(teacher);
    }

}
