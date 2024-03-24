package com.chushiy.study.mpj.service.impl;

import com.chushiy.study.mpj.pojo.TClass;
import com.chushiy.study.mpj.pojo.TStudent;
import com.chushiy.study.mpj.pojo.vo.TStudentVO;
import com.chushiy.study.mpj.service.TStudentService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/1/20 下午 6:49
 * @Description TODO
 * @ProjectName chushi
 * @PackageName com.chushi.study.mpj.service.impl
 * @ClassName TStudentServiceImplTest.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
// @ComponentScan("com.chushi.study.mpj")
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
class TStudentServiceImplTest {

    @Setter(onMethod=@__(@Autowired))
    // @Setter(onMethod_=@Autowired)
    private TStudentService tStudentService;

    @Test
    void test1() {
        List<TStudent> list = this.tStudentService.list();
        log.info("list:{}", list);
    }

    @Test
    void test2() {
        List<TStudentVO> list = this.tStudentService.selectJoinList(
                TStudentVO.class,
                new MPJLambdaWrapper<TStudent>()
                        .selectAll(TStudent.class)
                        // .select(TClass::getName,TStudentVO::getClassName)
                        // .select(TClass::getName)
                        .select("t_class.name `class_name`")
                        .leftJoin(TClass.class, "t_class", TClass::getId, TStudent::getClassId)
        );
        log.info("list:{}", list);
    }
}