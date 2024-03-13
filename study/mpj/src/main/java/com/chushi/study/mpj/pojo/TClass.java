package com.chushi.study.mpj.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 班级表(TClass)表实体类
 *
 * @author 初时
 * @since 2024-01-20 18:40:08
 */
@Data
@TableName("t_class")
public class TClass {

    /**
     * 班级id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 班级名字
     */
    private String name;
    /**
     * 入学年份
     */
    private Integer enrollmentYear;
    /**
     * 毕业年份
     */
    private Integer graduationYear;
}

