package com.chushiy.study.mpj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/20 下午 6:28
 * @Description TODO
 * @ProjectName chushi
 * @PackageName com.chushi.study.mpj
 * @ClassName MPJApplication.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@MapperScan("com.chushi.study.mpj.mapper")
@SpringBootApplication
public class MPJApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPJApplication.class, args);
    }
}
