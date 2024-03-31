package com.chushiy.study.mpj.pojo.vo;

import com.chushiy.study.mpj.pojo.TStudent;
import lombok.Data;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/20 下午 7:01
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy.study.mpj.pojo.vo
 * @ClassName TStudentVO.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
// @EqualsAndHashCode(callSuper = true)
@Data
public class TStudentVO extends TStudent {

    /**
     * 班级名字
     */
    private String className;
}
