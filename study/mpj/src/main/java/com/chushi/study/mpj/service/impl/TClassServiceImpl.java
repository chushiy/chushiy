package com.chushi.study.mpj.service.impl;


import com.chushi.study.mpj.mapper.TClassMapper;
import com.chushi.study.mpj.pojo.TClass;
import com.chushi.study.mpj.service.TClassService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 班级表(TClass)表服务实现类
 *
 * @author 初时
 * @since 2024-01-20 18:40:10
 */
@RequiredArgsConstructor
@Service("tClassService")
public class TClassServiceImpl extends MPJBaseServiceImpl<TClassMapper, TClass> implements TClassService {

    /**
     * 服务对象
     */
    private final TClassMapper tClassMapper;
}

