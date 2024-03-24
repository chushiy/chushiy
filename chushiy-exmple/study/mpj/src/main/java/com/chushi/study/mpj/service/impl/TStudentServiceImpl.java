package com.chushiy.study.mpj.service.impl;


import com.chushiy.study.mpj.mapper.TStudentMapper;
import com.chushiy.study.mpj.pojo.TStudent;
import com.chushiy.study.mpj.service.TStudentService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 学生表(TStudent)表服务实现类
 *
 * @author 初时
 * @since 2024-01-20 18:40:12
 */
@RequiredArgsConstructor
@Service("tStudentService")
public class TStudentServiceImpl extends MPJBaseServiceImpl<TStudentMapper, TStudent> implements TStudentService {

    /**
     * 服务对象
     */
    private final TStudentMapper tStudentMapper;
}

