package com.chushiy.study.mpj.mapper;


import com.chushiy.study.mpj.pojo.TClass;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 班级表(TClass)表数据库访问层
 *
 * @author 初时
 * @since 2024-01-20 18:40:08
 */
@Repository
@Mapper
public interface TClassMapper extends MPJBaseMapper<TClass> {

}

