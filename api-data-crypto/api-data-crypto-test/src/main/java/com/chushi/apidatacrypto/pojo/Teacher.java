package com.chushi.apidatacrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 8:23
 * @Description Teacher实体类，使用SpringBoot的validation校验
 * @ProjectName chushi
 * @PackageName com.chushi.apidatacrypto.pojo
 * @ClassName Teacher.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Teacher extends RequestBase {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Range(min = 0, max = 150, message = "年龄不合法")
    private Integer age;

    @NotNull(message = "生日不能为空")
    private Date birthday;

}
