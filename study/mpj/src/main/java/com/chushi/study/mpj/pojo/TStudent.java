package com.chushi.study.mpj.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * 学生表(TStudent)表实体类
 *
 * @author 初时
 * @since 2024-01-20 18:40:11
 */
@Data
@TableName("t_student")
public class TStudent {

    /**
     * 学号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 出生日期
     */
    private LocalDate dateOfBirth;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱地址
     */
    private String emailAddress;
    /**
     * 家庭住址
     */
    private String address;
}

